pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                echo 'Cloning the repository...'
                git url: 'https://github.com/guru2112/Maven.git', branch: 'master' // Update with your repo URL and branch
            }
        }
        
        stage('Build') {
            steps {
                echo 'Building the project...'
                bat 'mvn clean' // Adjust the command based on your needs
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'mvn test' // This will run your tests if you have any
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging the application...'
                // Packaging is typically done in the build stage, but you can do additional packaging here if needed
            }
        }
    }

    post {
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed.'
        }
    }
}
