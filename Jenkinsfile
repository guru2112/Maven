pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                echo 'Cloning the repository...'
                git url: 'https://github.com/guru2112/Maven.git', branch: 'main' // Update with your repo URL and branch
            }
        }
        
        stage('Build') {
            steps {
                echo 'Building the project...'
                sh 'mvn clean package' // Adjust the command based on your needs
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test' // This will run your tests if you have any
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
