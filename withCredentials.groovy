pipeline {
    agent {
        label 'jenkins-slave'
    }
    stages {
        stage('Example') {
            steps {
                script {
                    withCredentials([[
                        $class: 'AmazonWebServicesCredentialsBinding',
                        credentialsId: GKE_DEPLOY,
                        accessKeyVariable: 'AWS_ACCESS_KEY_ID',
                        secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
                            sh """
                            envsubst k8s-ecr-login-renew/values.yaml | helm upgrade -i k8s-ecr-login-renew --version 1.0.5 -f - nabsul/k8s-ecr-login-renew
                            """
                    }
                }
            }
        }
    }
}
