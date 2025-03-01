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
     stage('Deploy') {
         steps {
             echo '🚀 Déploiement de l\'application...'
             script {
                 sh 'docker stop my-app || true' // Arrête l'ancien conteneur s'il existe
                 sh 'docker rm my-app || true'   // Supprime l'ancien conteneur
                 sh 'docker run -d --name my-app -p 8080:8080 hello-world-app:latest'
                 echo "✅ [LOG] - Application déployée dans Docker !"
             }
         }
     }


      stage('Afficher Logs') {
          steps {
              echo '📜 Récupération des logs de l\'application...'
              sh 'tail -n 50 nohup.out || echo "🚨 Aucun log trouvé pour l\'application"'
              echo "✅ [LOG] - Affichage des logs terminé !"
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
