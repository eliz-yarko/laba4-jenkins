pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6'
        jdk 'jdk-17'
    }

    stages {
        stage('Clone') {
            steps {
                git branch: 'main', url: 'https://github.com/eliz-yarko/laba4-jenkins.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Report') {
            steps {
                sh 'mvn jacoco:report'
            }
        }
    }
}
