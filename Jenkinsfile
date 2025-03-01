pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo '📥 Clonage du dépôt...'
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
tools {
    git 'Git'
}

        stage('Deploy') {
            steps {
                echo '🚀 Déploiement de l\'application...'
                script {
                    def jarFile = sh(script: "ls target/*.jar", returnStdout: true).trim()
                    if (jarFile) {
                        sh "java -jar ${jarFile}"
                    } else {
                        error "🚨 Aucun fichier .jar trouvé dans le dossier target/"
                    }
                }
            }
        }
    }
}
