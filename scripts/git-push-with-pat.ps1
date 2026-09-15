<#
.SYNOPSIS
  現在のHEADを、GitHub PATで認証したリモートURL経由で指定ブランチへpushする共通ラッパー。

.DESCRIPTION
  withCredentials(usernamePassword(...)) で受け取った PAT_USER / PAT_TOKEN 環境変数を
  使い、origin のURLに認証情報を埋め込んだ上でpushする。
  copilot呼び出しステージではGH_TOKEN/GH_USERという変数名を使うと、copilot CLI自身が
  それを「Copilotへの認証情報」として誤認識してしまうため（実行手順書の不具合#6参照）、
  ここではあえて PAT_USER / PAT_TOKEN という変数名を前提にしている。

.PARAMETER Branch
  push先のリモートブランチ名。
#>
param(
  [Parameter(Mandatory = $true)]
  [string]$Branch
)

$authRemote = (git remote get-url origin) -replace '^https://', "https://${env:PAT_USER}:${env:PAT_TOKEN}@"
git push $authRemote "HEAD:$Branch"
