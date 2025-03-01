pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/niama22/hello-world-pipeline.git'
            }
        }

        stage('Build') {
            steps {
                echo '🔧 Compilation du projet...'
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                echo '🧪 Exécution des tests...'
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploiement de l'application..."

                sh 'java -jar target/*.jar'
            }
        }
    }
}
