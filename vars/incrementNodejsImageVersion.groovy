#!/user/bin/env groovy
def call () {
  echo 'Increment nodejs Image Version'
  dir('app') {
    sh 'npm install'
    sh 'npm version patch --no-git-tag-version'
    def jsonConfig = readJSON file: 'package.json'
    def VERSION = jsonConfig.version
    env.IMAGE_VERSION = VERSION 
}