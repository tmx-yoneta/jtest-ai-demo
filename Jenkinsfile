def violationsFound() {
  def reportPath = 'build/jtest/report.xml'
  if (!fileExists(reportPath)) {
    echo "violationsFound(): ${reportPath} が見つかりません。違反なしとして扱います。"
    return false
  }
  def content = readFile(file: reportPath, encoding: 'UTF-8')
  return content.contains('hasViols="true"')
}

pipeline {
  agent any
  parameters {
    booleanParam(name: 'AUTO_FIX', defaultValue: false, description: 'シナリオA：featureブランチでのAI自動修正を実行する（通常はfalseのまま運用）')
  }
  environment {
    JTEST_HOME                 = 'C:/Parasoft/jtest'
    ANALYZED_PROJECT_PATH      = "${WORKSPACE}"
    JTEST_STATIC_CONFIGURATION = 'builtin://Recommended Rules'
    MAVEN_OPTS                 = '-Dfile.encoding=UTF-8 -Dstdout.encoding=UTF-8 -Dstderr.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8'
    // Jenkinsサービス起動時のPATHにgh CLI／pythonが含まれていない可能性があるため、フルパスで参照する
    GH_EXE                     = 'C:\\Program Files\\GitHub CLI\\gh.exe'
    PYTHON_EXE                 = 'C:\\Users\\yoneta\\AppData\\Local\\Programs\\Python\\Python313\\python.exe'
  }
  stages {
    // ── シナリオA：featureブランチへのpush（PRでもmainでもないビルド） ──
    stage('A: コンパイル') {
      when {
        allOf {
          expression { env.CHANGE_ID == null } // PRではないビルド
          not { branch 'main' }
        }
      }
      steps {
        powershell '.\\mvnw -B -q compile'
      }
    }
    stage('A: 差分スコープ静的解析') {
      when {
        allOf {
          expression { env.CHANGE_ID == null }
          not { branch 'main' }
        }
      }
      steps {
        // Jtest本来のgit差分スコープ機能(scope.scontrol.*)は、このJenkins環境では
        // サービス実行コンテキスト特有の問題で機能しないことが実機検証で判明した(不具合#21)。
        // 対話セッションから同一コマンドを実行すると正しく1件検出されるが、Jenkinsサービス
        // 経由では常に0件（全ファイルが除外される）。原因はJVMのネイティブ/サブプロセスI/O
        // まわりのエンコーディングがコンソールを持たないWindowsサービスセッションで異なる
        // ことによるものと推測しているが、完全な根本原因の特定には至っていない
        // （不具合#16・copilotの装飾文字問題と同じ系統の問題）。
        // そのため、差分計算はPowerShell側のgitで行い、変更されたJavaファイルの一覧を
        // 直接-Djtest.resourcesで渡す方式に切り替えた。こちらはJtestのgit連携機能に
        // 依存しないため、この問題を回避できる。
        script {
          // 変更されたJavaファイルが1件もない場合、-Djtest.resourcesに何も一致しないパターンを
          // 渡すとJtest自体がエラー終了する（「テスト スコープが空です」）ため、その場合は
          // 解析自体をスキップする。
          def analyzed = powershell(returnStatus: true, script: '''
            git fetch origin main:refs/remotes/origin/main
            $changedFiles = git diff --name-only origin/main...HEAD -- "*.java"
            if (-not $changedFiles) {
              Write-Output "mainとの差分にJavaファイルの変更がないため、Jtest解析をスキップします。"
              exit 1
            }
            $changed = (($changedFiles | ForEach-Object { "**/$_" }) -join ",")
            Write-Output "差分スコープ対象ファイル: $changed"
            .\\mvnw.cmd jtest:jtest "-Djtest.report=build/jtest" "-Djtest.resources=$changed"
          ''') == 0
          if (analyzed) {
            recordIssues tools: [parasoftFindings(pattern: 'build/jtest/report.xml')], id: 'jtest-findings'
          } else {
            echo 'Jtest解析をスキップしたため、recordIssuesも実行しません。'
          }
        }
      }
    }
    stage('A: GitHub Checksへ結果報告（補助）') {
      when {
        allOf {
          expression { env.CHANGE_ID == null }
          not { branch 'main' }
        }
      }
      steps {
        withCredentials([usernamePassword(credentialsId: 'github-jtest-ai-pat', usernameVariable: 'GH_USER', passwordVariable: 'GH_TOKEN')]) {
          powershell '& $env:PYTHON_EXE scripts/report-to-github-check.py build/jtest/report.xml'
        }
      }
    }
    stage('A: AI修正提案（手動トリガー時のみ）') {
      when {
        allOf {
          expression { env.CHANGE_ID == null }
          not { branch 'main' }
          expression { params.AUTO_FIX == true }
        }
      }
      environment {
        JTEST_COMMIT_FIXES = 'true'
      }
      steps {
        withCredentials([usernamePassword(credentialsId: 'github-jtest-ai-pat', usernameVariable: 'PAT_USER', passwordVariable: 'PAT_TOKEN')]) {
          // JTEST_REFERENCE_BRANCH（スキル内部のgit差分スコープ機能）は不具合#21のため使わず、
          // 「A: 差分スコープ静的解析」と同じくPowerShell側で計算した変更ファイル一覧を
          // JTEST_RESOURCE経由でスキルに渡す（スキルはこれをそのまま-Djtest.resourcesに変換する）。
          powershell '''
            git fetch origin main:refs/remotes/origin/main
            $changedFiles = git diff --name-only origin/main...HEAD -- "*.java"
            $changed = (($changedFiles | ForEach-Object { "**/$_" }) -join ",")
            if ($changed) {
              $env:JTEST_RESOURCE = $changed
            }
            $prompt = "Use jtest-static-analysis to fix at most 3 violations introduced relative to main. Commit each fix separately."
            & .\\scripts\\invoke-copilot.ps1 -Prompt $prompt
            & .\\scripts\\git-push-with-pat.ps1 -Branch $env:BRANCH_NAME
          '''
        }
      }
    }

    // ── シナリオB：PRビルド（env.CHANGE_ID が非null） ──
    stage('B: ビルド') {
      when {
        expression { env.CHANGE_ID != null }  // PRビルド（env.CHANGE_ID が非null）の場合のみ実行
      }
      steps {
        powershell '.\\mvnw -B compile'
      }
    }
    stage('B: テスト実行') {
      when {
        expression { env.CHANGE_ID != null }
      }
      steps {
        powershell '.\\mvnw -B test'
      }
    }
    stage('B: Jtest静的解析') {
      when {
        expression { env.CHANGE_ID != null }
      }
      steps {
        powershell '.\\mvnw jtest:jtest "-Djtest.report=build/jtest"'
        recordIssues tools: [parasoftFindings(pattern: 'build/jtest/report.xml')], id: 'jtest-findings'
      }
    }
    stage('B: AI自動修正') {
      when {
        allOf {
          expression { env.CHANGE_ID != null }
          expression { violationsFound() }
        }
      }
      environment {
        JTEST_COMMIT_FIXES           = 'true'
        JTEST_STATIC_NO_OF_MAX_FIXES = '5'
      }
      steps {
        withCredentials([usernamePassword(credentialsId: 'github-jtest-ai-pat', usernameVariable: 'PAT_USER', passwordVariable: 'PAT_TOKEN')]) {
          powershell '''
            git checkout -B "ai-fix/$env:CHANGE_ID"
            $env:JTEST_STATIC_BASE_REPORT = "$env:WORKSPACE\\build\\jtest\\report.xml"
            $prompt = "Use jtest-static-analysis to fix at most 5 violations. Do not run build or Jtest analysis (already provided). Commit each fix separately."
            & .\\scripts\\invoke-copilot.ps1 -Prompt $prompt
            & .\\scripts\\git-push-with-pat.ps1 -Branch "ai-fix/$env:CHANGE_ID"
          '''
        }
      }
    }
    stage('B: PR通知') {
      when {
        allOf {
          expression { env.CHANGE_ID != null }
          expression { violationsFound() }
        }
      }
      steps {
        withCredentials([usernamePassword(credentialsId: 'github-jtest-ai-pat', usernameVariable: 'GH_USER', passwordVariable: 'GH_TOKEN')]) {
          powershell '& $env:GH_EXE pr comment $env:CHANGE_ID --body "AI remediation branch pushed: ai-fix/$env:CHANGE_ID"'
        }
      }
    }

    // ── シナリオC：mainブランチ（マージ後）のビルド ──
    stage('C: ビルド＆カバレッジ収集') {
      when {
        branch 'main'
      }
      steps {
        powershell '.\\mvnw -B clean test-compile jtest:agent test jtest:jtest "-Djtest.config=builtin://Unit Tests" "-Djtest.report=build/jtest"'
        recordIssues tools: [parasoftFindings(pattern: 'build/jtest/report.xml')], id: 'jtest-findings'
        // 閾値判定はrecordParasoftCoverage自身のQuality Gate機能に任せる（自前のcheck-coverage.pyは不要になった）。
        // 閾値未満のときはビルドをUNSTABLEにする（criticality: 'UNSTABLE'）。これは失敗ではなく、
        // 次の「C: ユニットテスト自動生成」が起動する合図として意図的に使っている。
        recordParasoftCoverage pattern: 'build/jtest/coverage.xml',
          coverageQualityGates: [[threshold: 80.0, type: 'PROJECT', criticality: 'UNSTABLE']]
      }
    }
    stage('C: カバレッジ判定') {
      when {
        branch 'main'
      }
      steps {
        script {
          // recordParasoftCoverageのQuality Gateが閾値未満と判定していればcurrentBuild.resultが
          // UNSTABLEになる。それ以外（null＝未設定、またはSUCCESS）なら閾値を満たしている。
          env.COVERAGE_OK = (currentBuild.result == null || currentBuild.result == 'SUCCESS') ? 'true' : 'false'
        }
      }
    }
    stage('C: ユニットテスト自動生成') {
      when {
        allOf {
          branch 'main'
          expression { env.COVERAGE_OK == 'false' }
        }
      }
      environment {
        JTEST_UTA_CONFIGURATION   = 'builtin://Create Unit Tests'
        JTEST_UTA_NO_OF_MAX_FIXES = '10'
        JTEST_FIX_ATTEMPTS        = '3'
        JTEST_COMMIT_FIXES        = 'true'
      }
      steps {
        withCredentials([usernamePassword(credentialsId: 'github-jtest-ai-pat', usernameVariable: 'PAT_USER', passwordVariable: 'PAT_TOKEN')]) {
          powershell '''
            git checkout -B "uta/coverage-boost-$env:BUILD_NUMBER"
            $prompt = "Use jtest-unit-testing to increase test coverage for the project. Commit each generated test separately."
            & .\\scripts\\invoke-copilot.ps1 -Prompt $prompt
            & .\\scripts\\git-push-with-pat.ps1 -Branch "uta/coverage-boost-$env:BUILD_NUMBER"
            $env:GH_TOKEN = $env:PAT_TOKEN
            & $env:GH_EXE pr create --title "Increase test coverage (auto-generated)" --body "Generated by jtest-unit-testing skill" --base main --head "uta/coverage-boost-$env:BUILD_NUMBER"
          '''
        }
      }
    }
  }
}
