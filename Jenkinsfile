pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch 'main', url 'httpsgithub.comniama22hello-world-pipeline.git'
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
                echo '🚀 Déploiement de l'application...'
                sh 'java -jar target.jar'
            }
        }
    }
}
