#!/user/bin/env groovy
def call () {
  withCredentials([usernamePassword(credentialsId: 'docker_credential', usernameVariable: 'USER', passwordVariable: 'PWD')]){
      echo "Building Application"
      sh "docker build -t nguyenmanhtrinh/demo-app:nodejs-${env.IMAGE_VERSION} ."
      sh "echo ${PWD} | docker login -u ${USER} --password-stdin"
      sh "docker push nguyenmanhtrinh/demo-app:nodejs-${env.IMAGE_VERSION}"
  }
}