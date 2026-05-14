pipeline {
    agent any

    tools {
        maven 'maven3'
        jdk 'JDK17'
    }

    stages {

        stage('Clone') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/ashwiniitti2005/openended.git'
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
                 subject: 'Jenkins Build Success',
                 body: 'Build completed successfully.'
        }

        failure {
            mail to: 'ashwiniitti28@gmail.com',
                 subject: 'Jenkins Build Failed',
                 body: 'Build failed.'
        }
    }
}
