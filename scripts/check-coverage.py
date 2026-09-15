#!/usr/bin/env python3
"""Parasoft Jtest の report.html からプロジェクト全体のカバレッジ率を読み取り、
閾値未満であれば exit 1 を返す（Jenkinsのカバレッジゲート判定用）。

Usage:
    python check-coverage.py <report.html> <threshold_percent>

注意（実装の背景）:
  coverage.xml は「どの行が計測対象か」のマップは持っているが、
  実際に何%カバーされたかという集計値は含まれていない（Jtest 2026.1.3で実機確認）。
  一方、report.html には Jtest 自身が計算した集計値が
  `<font class="..."><b>NN</b></font>%COVERED/TOTAL` という形で埋め込まれているため、
  本スクリプトはそちらをパースする。最初に出現する値がプロジェクト全体の合計値。
  report.html の文字コードはロケール依存（日本語環境ではShift_JIS）だが、
  パース対象はASCII範囲のタグ・数値のみなので、バイト列のまま正規表現で処理する。
"""
import re
import sys

PATTERN = re.compile(rb'<b>(\d+)</b></font>%(\d+)/(\d+)')


def main():
    if len(sys.argv) != 3:
        print("Usage: check-coverage.py <report.html> <threshold_percent>", file=sys.stderr)
        return 1

    report_path = sys.argv[1]
    try:
        threshold = float(sys.argv[2])
    except ValueError:
        print(f"[check-coverage] 閾値が数値ではありません: {sys.argv[2]}", file=sys.stderr)
        return 1

    try:
        with open(report_path, "rb") as f:
            data = f.read()
    except OSError as exc:
        print(f"[check-coverage] report.html を読み込めません: {exc}", file=sys.stderr)
        return 1

    m = PATTERN.search(data)
    if not m:
        print(
            "[check-coverage] report.html からカバレッジ集計値を抽出できませんでした。"
            "Jtestのバージョン差でHTML構造が変わった可能性があります。",
            file=sys.stderr,
        )
        return 1

    percent, covered, total = (int(x) for x in m.groups())
    print(f"[check-coverage] Line coverage: {covered}/{total} ({percent}%), threshold={threshold}%")

    if percent < threshold:
        print(f"[check-coverage] NG: カバレッジ {percent}% が閾値 {threshold}% を下回っています")
        return 1

    print(f"[check-coverage] OK: カバレッジ {percent}% は閾値 {threshold}% 以上です")
    return 0


if __name__ == "__main__":
    sys.exit(main())
