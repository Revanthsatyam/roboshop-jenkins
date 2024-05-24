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
        when {
          expression { env.BRANCH_NAME ==~ "main" }
        }
        steps {
          sh 'env'
        }
      }

      stage('Release') {
        steps {
          sh 'env'
        }
      }

    }
  }
}