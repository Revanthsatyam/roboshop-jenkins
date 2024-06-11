def call() {
  pipeline {
    agent any

    options {
      ansiColor('xterm')
    }

    environment {
      SSH = credentials('centos-ssh')
    }

    parameters {
      string(name: 'COMPONENT', defaultValue: 'Which Component To Deploy?')
      string(name: 'VERSION', defaultValue: 'Which Version To Deploy?')
      string(name: 'ENV', defaultValue: 'Which Environment To Deploy?')
    }

    stages {

      stage('Parameter Store Update') {
        steps {
          echo 'OK'
        }
      }

    }

  }
}