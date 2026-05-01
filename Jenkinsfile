pipeline {
    agent any

    tools {
        maven 'MyMaven'
        jdk 'jdk'
    }

    environment {
        BROWSER = 'chrome'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/sohell/Z_Cucumber_Test.git'
            }
        }

        stage('Clean & Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Execute Tests') {
            steps {
                bat "mvn test -Dbrowser=${BROWSER}"
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML([
                    reportDir: 'reports',
                    reportFiles: 'myreport.html',
                    reportName: 'Cucumber Report',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: true
                ])
            }
        }
    }

    post {
        success {
            echo 'All tests passed successfully!'
        }
        failure {
            echo 'Some tests failed. Check reports.'
        }
        always {
            archiveArtifacts artifacts: 'target/*.html'
        }
    }
}
