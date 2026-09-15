<#
.SYNOPSIS
  GitHub Copilot CLI (copilot.exe) を非対話モードで実行するための共通ラッパー。

.DESCRIPTION
  Jenkinsfile側の各ステージでは、このスクリプトに「どんな指示（プロンプト）を
  jtest-static-analysis / jtest-unit-testing スキルに与えるか」だけを書けば済むように、
  copilot.exe起動まわりの定型処理（引数構築・エンコーディング対策・出力の
  ストリーミング表示）をここに集約している。

  --add-dir や --allow-all-tools 等の固定引数、ANALYZED_PROJECT_PATH / JTEST_HOME
  といった環境変数はここで読み込む。JTEST_COMMIT_FIXES 等のスキル固有の設定は
  呼び出し側のJenkinsfileで環境変数として渡すこと（このスクリプトでは扱わない）。

  なぜ `& copilot.exe @args` のような単純な呼び出しではなく .NET の Process API を
  使っているかは、実行手順書（Jtest生成AI_CI連携_実行手順書.md）の不具合一覧
  #5・#13・#14・#16を参照。要点は、PowerShellの標準的なネイティブコマンド
  呼び出しでは、Jenkinsサービスの実行コンテキスト特有の要因でcopilotの出力が
  正しいエンコーディングで読み取れないことがあるため。

.PARAMETER Prompt
  copilotに渡す非対話プロンプト（-p オプションの値）。
#>
param(
  [Parameter(Mandatory = $true)]
  [string]$Prompt
)

$copilotArgs = @(
  "--add-dir", $env:ANALYZED_PROJECT_PATH,
  "--add-dir", $env:JTEST_HOME,
  "--add-dir", "$env:JTEST_HOME/integration/ai/skills",
  "--add-dir", "$env:USERPROFILE/.copilot/skills",
  "--allow-all-tools",
  "--silent",
  "-p", $Prompt
)

$psi = New-Object System.Diagnostics.ProcessStartInfo
$psi.FileName = "copilot.exe"
$psi.Arguments = (($copilotArgs | ForEach-Object {
  if ($_ -match '[\s"]') { '"' + ($_ -replace '"', '""') + '"' } else { $_ }
}) -join ' ')
$psi.RedirectStandardOutput = $true
$psi.RedirectStandardError = $true
$psi.UseShellExecute = $false
# copilotはUTF-8で出力するが、既定の読み取りでは正しく解釈されないことがあるため明示する
$psi.StandardOutputEncoding = [System.Text.Encoding]::UTF8
$psi.StandardErrorEncoding = [System.Text.Encoding]::UTF8

$proc = [System.Diagnostics.Process]::Start($psi)
$errTask = $proc.StandardError.ReadToEndAsync()
while (($line = $proc.StandardOutput.ReadLine()) -ne $null) { Write-Output $line }
$proc.WaitForExit()
if ($errTask.Result) { Write-Output $errTask.Result }

exit $proc.ExitCode
