pipeline {

    agent any

    tools {
        maven 'maven3'
        jdk 'JDK17'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/ashwiniitti2005/openended.git',
                    credentialsId: 'github-token'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Run Application') {
            steps {
                sh 'java -cp target/library-app-1.0.jar com.library.Library'
            }
        }
    }

    post {

        success {
            emailext (
                subject: "SUCCESS: ${JOB_NAME} #${BUILD_NUMBER}",
                body: """
Build succeeded successfully.

Project: Library Management System
Job Name: ${JOB_NAME}
Build Number: ${BUILD_NUMBER}

Check Console Output:
${BUILD_URL}
""",
                to: "ashwiniitti28@gmail.com"
            )
        }

        failure {
            emailext (
                subject: "FAILED: ${JOB_NAME} #${BUILD_NUMBER}",
                body: """
Build failed.

Project: Library Management System
Job Name: ${JOB_NAME}
Build Number: ${BUILD_NUMBER}

Check Error Logs:
${BUILD_URL}
""",
                to: "ashwiniitti28@gmail.com"
            )
        }
    }
}
