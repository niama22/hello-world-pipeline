pipeline {
    agent any

    tools {
        maven 'Maven' // Assurez-vous que Maven est bien configuré dans Jenkins
    }

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

        stage('Deploy') {
            steps {
                echo '🚀 Déploiement de l\'application...'

                // Vérification si le fichier .jar existe
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
