<#
.SYNOPSIS
  現在のHEADを、GitHub PATで認証したリモートURL経由で指定ブランチへpushする共通ラッパー。

.DESCRIPTION
  withCredentials(usernamePassword(...)) で受け取った PAT_USER / PAT_TOKEN 環境変数を
  使い、origin のURLに認証情報を埋め込んだ上でpushする。
  copilot呼び出しステージではGH_TOKEN/GH_USERという変数名を使うと、copilot CLI自身が
  それを「Copilotへの認証情報」として誤認識してしまうため（実行手順書の不具合#6参照）、
  ここではあえて PAT_USER / PAT_TOKEN という変数名を前提にしている。

  常にforce push（--force）する。呼び出し元は必ず事前に`git checkout -B`でブランチを
  作り直しているため（ai-fix/*, nightly-fix/*, uta/coverage-boost-*等、いずれも「毎回
  最新の状態から作り直す」設計の使い捨てブランチ）、リモート側に前回のpush結果が残って
  いると通常のpushは必ずnon-fast-forwardで失敗する（実行手順書の不具合#22参照）。
  なお--force-with-leaseは「ローカルが直前にfetchしたリモートの状態」を前提にするため、
  Jenkinsのワークスペースで対象ブランチを一度もfetchしていない場合に誤って拒否される
  ことがあり、この用途（人間との競合を想定しない使い捨てブランチへの単独書き込み）には
  不向き。単純な--forceを使う。

.PARAMETER Branch
  push先のリモートブランチ名。
#>
param(
  [Parameter(Mandatory = $true)]
  [string]$Branch
)

$authRemote = (git remote get-url origin) -replace '^https://', "https://${env:PAT_USER}:${env:PAT_TOKEN}@"
git push --force $authRemote "HEAD:$Branch"
