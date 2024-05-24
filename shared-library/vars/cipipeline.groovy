def call() {
  pipeline {
    agent any

    stages {

      stage('Compile Code') {
        steps {
          echo 'Hello World'
        }
      }

      stage('Test') {
        steps {
          echo 'Hello World'
        }
      }

      stage('Code Quality') {
        steps {
          echo 'Hello World'
        }
      }

      stage('Code Security') {
        steps {
          echo 'Hello World'
        }
      }

      stage('Release') {
        when {
          expression { env.TAG_NAME != null }
        }
        steps {
          echo 'Hello World'
        }
      }

    }
  }
}
