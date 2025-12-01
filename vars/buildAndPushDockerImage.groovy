#!/user/bin/env groovy
import ../src/com.example/Docker.groovy

def call () {
  return new Docker(this).buildAndPushDockerImage()
}