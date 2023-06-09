pipeline{
    agent any
    tools {
      maven 'maven3'
    }
    options {
        // This is required if you want to clean before build
        skipDefaultCheckout(true)
    }
    stages{
        stage('Build') {
            steps {
                // Clean before build
                cleanWs()
                // We need to explicitly checkout from SCM here
                echo "Building ${env.JOB_NAME}..."
            }
        }
        stage('Git Pull'){
            steps{
                git branch: 'main', credentialsId: 'github', url: 'https://github.com/shivansh-sethi-2000/Spe_calc_proj.git'
            }
        }
        
        stage('Maven Build'){
            steps{
                sh "mvn clean package"
            }
        }
        
        stage('Maven Test') { 
            steps {
                sh 'mvn test' 
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
        
        stage('Docker Build'){
            steps{
                sh "docker build . -t shivanshsethi2000/spe_mini_proj:latest "
            }
        }
        
        stage('DockerHub Push'){
            steps{
                withDockerRegistry([credentialsId: 'docker-hub-cred', url: ""]) {
                    sh "docker push shivanshsethi2000/spe_mini_proj:latest"
                }
            }
        }
        
        stage('Docker Deploy'){
            steps{
              ansiblePlaybook disableHostKeyChecking: true, installation: 'ansible', inventory: 'proj_inv', playbook: 'playbook.yml'
            }
        }
    }
}
