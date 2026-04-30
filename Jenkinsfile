pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
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

        stage('Generate Report') {
            steps {
                publishHTML([
                    reportDir: 'target',
                    reportFiles: 'cucumber-report.html',
                    reportName: 'Cucumber Report'
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