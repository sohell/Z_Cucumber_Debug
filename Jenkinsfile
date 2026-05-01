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
                bat "mvn test"
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
    }

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
