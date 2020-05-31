#!groovy
@Library('jenkins-shared-library')
import com.sivalabs.JenkinsSharedLib

properties([
    parameters([
        booleanParam(defaultValue: false, name: 'PUBLISH_TO_DOCKERHUB', description: 'Publish Docker Image to DockerHub?')
    ])
])

def DOCKER_USERNAME = 'sivaprasadreddy'
def APP_IMAGE_NAME = 'spring-boot-todolist'

def utils = new JenkinsSharedLib(this, env, params, scm, currentBuild)

node {

    try {
        utils.checkout()
        utils.runMavenTests("Test")
        utils.publishDockerImage("Publish Docker Image", DOCKER_USERNAME, APP_IMAGE_NAME)
    }
    catch(err) {
        echo "ERROR: ${err}"
        currentBuild.result = currentBuild.result ?: "FAILURE"
    }
}