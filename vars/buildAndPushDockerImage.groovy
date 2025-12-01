#!/user/bin/env groovy
import com.example.Docker

def call (String DOCKER_REPO, String IMAGE_NAME) {
  return new Docker(this).buildAndPushDockerImage(DOCKER_REPO, IMAGE_NAME)
}