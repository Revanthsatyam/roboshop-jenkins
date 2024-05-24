def call() {
  pipeline {
    agent any

    stages {

      stage('Compile Code') {
        steps {
          sh 'env'
          echo 'Hello World'
        }
      }

      stage('Test') {
        when {
          allof {
            expression { env.BRANCH_NAME != null }
            expression { env.TAG_NAME == null }
          }
        }
        steps {
          echo 'Hello World'
        }
      }

      stage('Code Quality') {
        when {
          allof {
            expression { env.BRANCH_NAME != null }
            expression { env.TAG_NAME == null }
          }
        }
        steps {
          echo 'Hello World'
        }
      }

      stage('Code Security') {
        when {
          expression { env.BRANCH_NAME ==~ "main" }
        }
        steps {
          echo 'Hello World'
        }
      }

      stage('Release') {
        when {
          expression { env.TAG_NAME != null }
        }
        steps {
          sh 'env'
          echo 'Hello World'
        }
      }

    }
  }
}