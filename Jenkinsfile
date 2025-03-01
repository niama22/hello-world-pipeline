pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo '📥 Clonage du dépôt...'
                git branch: 'main', url: 'https://github.com/niama22/hello-world-pipeline.git'
                echo '✅ [LOG] - Clonage terminé avec succès !'
            }
        }

        stage('Build') {
            steps {
                echo '🔧 Compilation du projet...'
                sh 'mvn clean package'
                echo '✅ [LOG] - Build terminé avec succès !'
            }
        }

        stage('Test') {
            steps {
                echo '🧪 Exécution des tests...'
                sh 'mvn test'
                echo '✅ [LOG] - Tests exécutés avec succès !'
            }
        }

        stage('Deploy') {
            steps {
                echo '🚀 Déploiement de l\'application...'
                script {
                    def jarFile = sh(script: "ls target/*.jar", returnStdout: true).trim()
                    if (jarFile) {
                        echo "✅ [LOG] - Fichier JAR trouvé : ${jarFile}"
                        sh "java -jar ${jarFile} &"
                        echo "✅ [LOG] - Application démarrée avec succès !"
                    } else {
                        error "🚨 [LOG] - Aucun fichier .jar trouvé dans le dossier target/"
                    }
                }
            }
        }

        stage('Afficher Logs') {
            steps {
                echo '📜 Récupération des logs de l\'application...'
                sh 'docker logs my-app || echo "🚨 Aucun log trouvé pour my-app"'
                echo "✅ [LOG] - Affichage des logs terminé !"
            }
        }
    }

    post {
        success {
            echo '🎉 [LOG] - Pipeline exécuté avec succès !'
        }
        failure {
            echo '❌ [LOG] - Échec du pipeline ! Consultez les logs pour plus d\'informations.'
        }
    }
}
