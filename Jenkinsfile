pipeline {
    agent any
    tools {
        maven 'my-maven'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn clean package'
                
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
            post {
                success {
                    echo 'Now archiving the artifacts'
                    archiveArtifacts artifacts: '**/*.jar'
                }
            }
        }
        stage('staging') {
            steps {
                 build job: 'doxa_FStyle'
            }
        }
    }
}
