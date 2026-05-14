pipeline {

    agent any

    tools {
        maven 'maven3'
        jdk 'JDK17'
    }

    stages {

        stage('Clone') {
            steps {
                git 'https://github.com/ashwiniitti2005/openended.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }

    post {

        success {
            mail to: 'ashwiniitti28@gmail.com',
            subject: 'Library App Build Success',
            body: 'Build Successful'
        }

        failure {
            mail to: 'ashwiniitti28@gmail.com',
            subject: 'Library App Build Failed',
            body: 'Build Failed'
        }
    }
}
