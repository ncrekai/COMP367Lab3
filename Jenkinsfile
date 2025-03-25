pipeline {
    agent any

    tools {
        maven "Maven3.9"
    }

    stages {
        // stage('Checkout') {
        //     steps {
        //         checkout scmGit(branches: [[name: '*/main']],
        //         userRemoteConfigs: [[credentialsId: 'fc119a1e-8277-4052-b3ea-73c9128d6797', 
        //         url: 'https://github.com/ncrekai/COMP367Lab3.git']])
        //     }
        // }
        // stage("Compile"){
        //     steps{
        //         sh "mvn clean compile"
        //     }
        // }
        // stage('Build') {
        //     steps {
        //     //    sh " mvn clean package"
        //        echo "I live here: ${env.WORKSPACE}"
        //         // archiveArtifacts artifacts: '/target/*.jar', fingerprint: true
        //         // archiveArtifacts artifacts: '../RekaiLab3.jar', fingerprint: true
        //     }
        // }

        stage('Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']],
                userRemoteConfigs: [[credentialsId: 'fc119a1e-8277-4052-b3ea-73c9128d6797', 
                url: 'https://github.com/ncrekai/COMP367Lab3.git']])
            }
        }
        stage("Compile"){
            steps{
                sh "mvn clean compile"
            }
        }
        stage('Build') {
            steps {
               sh "mvn clean package"
               archiveArtifacts artifacts: '../RekaiLab3.jar', fingerprint: true
            }
        }
    }
}
