pipeline {
    agent any

    tools {
        maven "Maven3.9"
    }
    environment {
        DOCKERHUB_PWD=credentials("NatalieDocker")
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
                    sh "docker build -t natalie/lab3mavendockerbuild:latest ."
                }
            }
        }

        stage("Docker Push") {
            steps {
                script {
                    sh "docker login -u nrekai -p ${DOCKERHUB_PWD}"
                    sh "docker push natalie/lab3mavendockerbuild:latest"
                }
            }
        }
        

        // stage("Compile"){
        //     steps{
        //         sh "mvn clean compile"
        //     }
        // }
        // stage("Build") {
        //     steps {
        //        sh "mvn clean package"
        //     }
        // }
    }
}
