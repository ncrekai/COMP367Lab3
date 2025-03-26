pipeline {
    agent any

    tools {
        maven "Maven3.9"
    }

    stages {
        stage("Checkout") {
            steps {
                git branch: "main", url: "https://github.com/ncrekai/COMP367Lab3.git"
            }
        }

        stage("Build Maven Project") {
            steps {
                sh "mvn clean install"
            }
        }

        stage("Docker Build") {
            steps {
                script {
                    sh "docker build -t nrekai/natalie_repo ."
                }
            }
        }

        stage("Docker Push") {
            steps {
                withCredentials([usernamePassword(credentialsId: 'NatalieDocker2', passwordVariable: 'dockerpw', usernameVariable: 'dockeruser')]) {
                    sh "docker login -u ${env.dockeruser} -p ${env.dockerpw}"
                    sh "docker push nrekai/natalie_repo"
                }
            }
        }
    }
}