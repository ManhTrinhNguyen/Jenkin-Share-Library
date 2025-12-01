#!/user/bin/env groovy
import com.example.Docker

def call () {
  return new Docker(this).buildAndPushDockerImage(String DOCKER_REPO, String IMAGE_NAME)
}