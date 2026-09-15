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
    MAVEN_OPTS                 = '-Dfile.encoding=MS932'
    // Jenkinsサービス起動時のPATHにgh CLI／pythonが含まれていない可能性があるため、フルパスで参照する
    GH_EXE                     = 'C:\\Program Files\\GitHub CLI\\gh.exe'
    PYTHON_EXE                 = 'C:\\Users\\yoneta\\AppData\\Local\\Programs\\Python\\Python313\\python.exe'
  }
  stages {
    // ── シナリオA：featureブランチへのpush（PRでもmainでもないビルド） ──
    stage('A: Compile') {
      when {
        allOf {
          expression { env.CHANGE_ID == null }
          not { branch 'main' }
        }
      }
      steps {
        powershell '''
          .\\mvnw -B -q compile
          '''
      }
    }
    stage('A: Diff-Scoped Static Analysis') {
      when {
        allOf {
          expression { env.CHANGE_ID == null }
          not { branch 'main' }
        }
      }
      environment {
        JTEST_REFERENCE_BRANCH = 'main'
      }
      steps {
        bat '''
          mvnw.cmd jtest:jtest "-Djtest.report=build/jtest"
        '''
      }
    }
    stage('A: Report to GitHub Check') {
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
    stage('A: AI Suggest Fix (manual trigger only)') {
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
          powershell '''
            $prompt = "Use jtest-static-analysis to fix at most 3 violations introduced relative to main. Commit each fix separately."
            $copilotArgs = @(
              "--add-dir", $env:ANALYZED_PROJECT_PATH,
              "--add-dir", $env:JTEST_HOME,
              "--add-dir", "$env:JTEST_HOME/integration/ai/skills",
              "--add-dir", "$env:USERPROFILE/.copilot/skills",
              "--allow-all-tools",
              "-p", $prompt
            )
            $psi = New-Object System.Diagnostics.ProcessStartInfo
            $psi.FileName = "copilot.exe"
            $psi.Arguments = (($copilotArgs | ForEach-Object {
              if ($_ -match '[\\s"]') { '"' + ($_ -replace '"', '""') + '"' } else { $_ }
            }) -join ' ')
            $psi.RedirectStandardOutput = $true
            $psi.RedirectStandardError = $true
            $psi.UseShellExecute = $false
            $psi.StandardOutputEncoding = [System.Text.Encoding]::UTF8
            $psi.StandardErrorEncoding = [System.Text.Encoding]::UTF8
            $copilotProc = [System.Diagnostics.Process]::Start($psi)
            $copilotOutTask = $copilotProc.StandardOutput.ReadToEndAsync()
            $copilotErrTask = $copilotProc.StandardError.ReadToEndAsync()
            $copilotProc.WaitForExit()
            Write-Output $copilotOutTask.Result
            if ($copilotErrTask.Result) { Write-Output $copilotErrTask.Result }
            $authRemote = (git remote get-url origin) -replace '^https://', "https://${env:PAT_USER}:${env:PAT_TOKEN}@"
            git push $authRemote "HEAD:$env:BRANCH_NAME"
          '''
        }
      }
    }

    // ── シナリオB：PRビルド（env.CHANGE_ID が非null） ──
    stage('B: Build') {
      when {
        expression { env.CHANGE_ID != null }
      }
      steps {
        powershell '.\\mvnw -B compile'
      }
    }
    stage('B: Test') {
      when {
        expression { env.CHANGE_ID != null }
      }
      steps {
        powershell '.\\mvnw -B test'
      }
    }
    stage('B: Jtest Static Analysis') {
      when {
        expression { env.CHANGE_ID != null }
      }
      steps {
        powershell '.\\mvnw jtest:jtest "-Djtest.report=build/jtest"'
      }
    }
    stage('B: AI Remediation') {
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
            $copilotArgs = @(
              "--add-dir", $env:ANALYZED_PROJECT_PATH,
              "--add-dir", $env:JTEST_HOME,
              "--add-dir", "$env:JTEST_HOME/integration/ai/skills",
              "--add-dir", "$env:USERPROFILE/.copilot/skills",
              "--allow-all-tools",
              "-p", $prompt
            )
            $psi = New-Object System.Diagnostics.ProcessStartInfo
            $psi.FileName = "copilot.exe"
            $psi.Arguments = (($copilotArgs | ForEach-Object {
              if ($_ -match '[\\s"]') { '"' + ($_ -replace '"', '""') + '"' } else { $_ }
            }) -join ' ')
            $psi.RedirectStandardOutput = $true
            $psi.RedirectStandardError = $true
            $psi.UseShellExecute = $false
            $psi.StandardOutputEncoding = [System.Text.Encoding]::UTF8
            $psi.StandardErrorEncoding = [System.Text.Encoding]::UTF8
            $copilotProc = [System.Diagnostics.Process]::Start($psi)
            $copilotOutTask = $copilotProc.StandardOutput.ReadToEndAsync()
            $copilotErrTask = $copilotProc.StandardError.ReadToEndAsync()
            $copilotProc.WaitForExit()
            Write-Output $copilotOutTask.Result
            if ($copilotErrTask.Result) { Write-Output $copilotErrTask.Result }
            $authRemote = (git remote get-url origin) -replace '^https://', "https://${env:PAT_USER}:${env:PAT_TOKEN}@"
            git push $authRemote "ai-fix/$env:CHANGE_ID"
          '''
        }
      }
    }
    stage('B: Notify') {
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
    stage('C: Build & Collect Coverage') {
      when {
        branch 'main'
      }
      steps {
        powershell '.\\mvnw -B clean test-compile jtest:agent test jtest:jtest "-Djtest.config=builtin://Unit Tests" "-Djtest.report=build/jtest"'
      }
    }
    stage('C: Check Coverage Gate') {
      when {
        branch 'main'
      }
      steps {
        script {
          env.COVERAGE_OK = (powershell(script: '& $env:PYTHON_EXE scripts/check-coverage.py build/jtest/report.html 80', returnStatus: true) == 0) ? 'true' : 'false'
        }
      }
    }
    stage('C: Generate Unit Tests') {
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
            $copilotArgs = @(
              "--add-dir", $env:ANALYZED_PROJECT_PATH,
              "--add-dir", $env:JTEST_HOME,
              "--add-dir", "$env:JTEST_HOME/integration/ai/skills",
              "--add-dir", "$env:USERPROFILE/.copilot/skills",
              "--allow-all-tools",
              "-p", $prompt
            )
            $psi = New-Object System.Diagnostics.ProcessStartInfo
            $psi.FileName = "copilot.exe"
            $psi.Arguments = (($copilotArgs | ForEach-Object {
              if ($_ -match '[\\s"]') { '"' + ($_ -replace '"', '""') + '"' } else { $_ }
            }) -join ' ')
            $psi.RedirectStandardOutput = $true
            $psi.RedirectStandardError = $true
            $psi.UseShellExecute = $false
            $psi.StandardOutputEncoding = [System.Text.Encoding]::UTF8
            $psi.StandardErrorEncoding = [System.Text.Encoding]::UTF8
            $copilotProc = [System.Diagnostics.Process]::Start($psi)
            $copilotOutTask = $copilotProc.StandardOutput.ReadToEndAsync()
            $copilotErrTask = $copilotProc.StandardError.ReadToEndAsync()
            $copilotProc.WaitForExit()
            Write-Output $copilotOutTask.Result
            if ($copilotErrTask.Result) { Write-Output $copilotErrTask.Result }
            $authRemote = (git remote get-url origin) -replace '^https://', "https://${env:PAT_USER}:${env:PAT_TOKEN}@"
            git push $authRemote "uta/coverage-boost-$env:BUILD_NUMBER"
            $env:GH_TOKEN = $env:PAT_TOKEN
            & $env:GH_EXE pr create --title "Increase test coverage (auto-generated)" --body "Generated by jtest-unit-testing skill" --base main --head "uta/coverage-boost-$env:BUILD_NUMBER"
          '''
        }
      }
    }
  }
}

