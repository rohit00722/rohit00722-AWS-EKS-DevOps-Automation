pipeline {
    agent any
    
    environment {
        AWS_REGION = 'us-east-1'  
        ECR_REPO = 'your-ecr-repository'  
        IMAGE_NAME = 'your-app-image'  
        K8S_NAMESPACE = 'prod-main'  

        SONAR_HOST_URL = 'http://<JENKINS-EC2-IP>:9000'  
        SONAR_PROJECT_KEY = 'my-project'
    }
    
    triggers {
        cron('0 4 * * *')  
    }
    
    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/your-repo.git'  
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                script {
                    sh """
                    sonar-scanner \
                        -Dsonar.projectKey=${SONAR_PROJECT_KEY} \
                        -Dsonar.sources=. \
                        -Dsonar.host.url=${SONAR_HOST_URL} \
                        -Dsonar.login=your-sonarqube-token
                    """
                }
            }
        }
        
        stage('Run Tests') {
            steps {
                sh 'echo Running Tests...'
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    def imageTag = "${env.IMAGE_NAME}:latest"
                    sh "docker build -t ${imageTag} ."
                }
            }
        }
        
        stage('Push Image to ECR') {
            steps {
                script {
                    def imageTag = "${env.IMAGE_NAME}:latest"
                    sh "aws ecr get-login-password --region ${AWS_REGION} | docker login --username AWS --password-stdin ${ECR_REPO}"
                    sh "docker tag ${imageTag} ${ECR_REPO}/${imageTag}"
                    sh "docker push ${ECR_REPO}/${imageTag}"
                }
            }
        }
        
        stage('Deploy to EKS') {
            steps {
                script {
                    sh "kubectl set image deployment/${IMAGE_NAME} ${IMAGE_NAME}=${ECR_REPO}/${IMAGE_NAME}:latest -n ${K8S_NAMESPACE}"
                    sh "kubectl rollout status deployment/${IMAGE_NAME} -n ${K8S_NAMESPACE}"
                }
            }
        }
    }
}
