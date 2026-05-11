pipeline {
    agent any

    triggers {
        githubPush()
    }
    
    tools {
        maven 'MyMaven'
        jdk 'jdk'
    }

    environment {
        BROWSER = 'chrome'
    }

    stages {   // ✅ MISSING BLOCK ADDED

        stage('Clean & Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Execute Tests') {
            steps {
                bat 'mvn test -Dcucumber.filter.tags=@smoke'
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML([
                    reportDir: 'target/cucumber-html-reports',
                    reportFiles: 'index.html',
                    reportName: 'Cucumber Report',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
                ])
            }
        }
    }   // ✅ closes stages

    post {
        success {
            echo 'All tests passed successfully!'
        }
        failure {
            echo 'Some tests failed. Check reports.'
        }
        always {
            archiveArtifacts artifacts: 'reports/*.html'
        }
    }
}
