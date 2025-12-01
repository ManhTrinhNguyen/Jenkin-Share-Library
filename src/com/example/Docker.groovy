#!/user/bin/env groovy

package com.example

class Docker implements Serializable {
  def script

  Docker(script) {
    this.script = script 
  }

  def buildAndPushDockerImage () {
    script.echo "Building Application"
    script.withCredentials([script.usernamePassword(credentialsId: 'docker_credential', usernameVariable: 'USER', passwordVariable: 'PWD')]){
      script.echo "Building Application"
      script.sh "docker build -t nguyenmanhtrinh/demo-app:nodejs-${script.env.IMAGE_VERSION} ."
      script.sh "echo '${script.PWD}' | docker login -u '${script.USER}' --password-stdin"
      script.sh "docker push nguyenmanhtrinh/demo-app:nodejs-${script.env.IMAGE_VERSION}"
    }
  }
}