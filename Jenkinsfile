pipeline {
	agent any

    tools {
		maven 'Maven 3.9.2'
        jdk 'Java 17'
    }

    stages {
		stage('Checkout') {
			steps {
				git url: 'https://github.com/eliz-yarko/laba4-jenkins.git', branch: 'main'
            }
        }

        stage('Build') {
			steps {
				bat 'mvn clean install'
            }
        }

        stage('Test') {
			steps {
				bat 'mvn test'
            }
        }

        stage('Coverage') {
			steps {
				bat 'mvn jacoco:report'
            }
        }
    }

    post {
		always {
			junit '**/target/surefire-reports/*.xml'
            jacoco execPattern: '**/target/jacoco.exec'
        }
    }
}
