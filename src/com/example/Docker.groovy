#!/user/bin/env groovy

package com.example

class Docker implements Serializable {
  def script

  Docker(script) {
    this.script = script 
  }

  def buildAndPushDockerImage (String DOCKER_REPO, String IMAGE_NAME) {
    script.echo "Building Application"
    script.withCredentials([script.usernamePassword(credentialsId: 'docker_credential', usernameVariable: 'USER', passwordVariable: 'PWD')]){
      script.echo "Building Application"
      script.sh "docker build -t ${DOCKER_REPO}:${IMAGE_NAME}-${script.env.IMAGE_VERSION} ."
      script.sh "echo '${script.PWD}' | docker login -u '${script.USER}' --password-stdin"
      script.sh "docker push ${DOCKER_REPO}:${IMAGE_NAME}-${script.env.IMAGE_VERSION}"
    }
  }
}
// nguyenmanhtrinh/demo-app

// nodejs