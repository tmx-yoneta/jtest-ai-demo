#!/usr/bin/env python3
"""Parasoft Jtest の report.xml を解析し、GitHubのコミットステータスとして投稿する。

Usage:
    python report-to-github-check.py <report.xml>

Env:
    GH_TOKEN   GitHubへのAPI呼び出しに使うトークン（JenkinsのwithCredentials経由で渡す想定）
    GH_USER    未使用（withCredentials(usernamePassword)の対で渡ってくるが、トークン認証には不要）
    GIT_COMMIT Jenkinsが自動設定するコミットSHA（未設定ならgit rev-parse HEADで代用）
    BUILD_URL  Jenkinsが自動設定するビルド結果URL（あればstatusのtarget_urlに使う）

report.xmlが読めない、GH_TOKENが無い、API呼び出しに失敗した場合でも、
このステージはビルド全体を失敗させたくないため、常にexit 0で終了する
（＝GitHub Checksへの表示は「できれば付加する」情報であり、必須ゲートではない）。
"""
import json
import os
import re
import subprocess
import sys
import urllib.error
import urllib.request


def run_git(*args):
    return subprocess.check_output(["git", *args], text=True).strip()


def parse_owner_repo():
    override = os.environ.get("GITHUB_REPOSITORY")
    if override and "/" in override:
        owner, repo = override.split("/", 1)
        return owner, repo
    url = run_git("remote", "get-url", "origin")
    m = re.search(r"github\.com[:/]+([^/]+)/([^/.]+?)(?:\.git)?$", url)
    if not m:
        raise ValueError(f"origin のURLからowner/repoを判別できません: {url}")
    return m.group(1), m.group(2)


def parse_report(report_path):
    with open(report_path, "rb") as f:
        data = f.read()
    head = data[:4000].decode("utf-8", errors="replace")
    m = re.search(r'hasViols="(true|false)"', head)
    has_viols = (m.group(1) == "true") if m else False
    viol_count = len(re.findall(rb"<(?:Std|Flow|Exec|Unit)Viol[ /]", data))
    return has_viols, viol_count


def post_status(owner, repo, sha, token, state, description, context):
    url = f"https://api.github.com/repos/{owner}/{repo}/statuses/{sha}"
    payload = {
        "state": state,
        "description": description[:140],
        "context": context,
    }
    target_url = os.environ.get("BUILD_URL")
    if target_url:
        payload["target_url"] = target_url
    req = urllib.request.Request(
        url,
        data=json.dumps(payload).encode("utf-8"),
        method="POST",
        headers={
            "Authorization": f"Bearer {token}",
            "Accept": "application/vnd.github+json",
            "User-Agent": "jtest-ai-poc-report-to-github-check",
            "Content-Type": "application/json",
        },
    )
    with urllib.request.urlopen(req, timeout=30) as resp:
        return resp.status


def main():
    if len(sys.argv) != 2:
        print("Usage: report-to-github-check.py <report.xml>", file=sys.stderr)
        return 0

    report_path = sys.argv[1]
    if not os.path.isfile(report_path):
        print(f"[report-to-github-check] report.xml が見つかりません: {report_path}（スキップします）")
        return 0

    token = os.environ.get("GH_TOKEN")
    if not token:
        print("[report-to-github-check] GH_TOKEN が未設定のため、GitHubへの投稿をスキップします")
        return 0

    try:
        has_viols, viol_count = parse_report(report_path)
        owner, repo = parse_owner_repo()
        sha = os.environ.get("GIT_COMMIT") or run_git("rev-parse", "HEAD")

        state = "failure" if has_viols else "success"
        description = (
            f"Jtest static analysis: {viol_count} violation(s) found"
            if has_viols
            else "Jtest static analysis: no violations found"
        )

        status = post_status(owner, repo, sha, token, state, description, "jtest/static-analysis")
        print(f"[report-to-github-check] GitHub commit status を投稿しました（HTTP {status}）: {description}")
    except Exception as exc:  # noqa: BLE001 - このステージは情報表示のみなので失敗させない
        print(f"[report-to-github-check] 投稿に失敗しましたが、ビルドは継続します: {exc}")

    return 0


if __name__ == "__main__":
    sys.exit(main())
