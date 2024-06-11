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
      string(name: 'COMPONENT', defaultValue: '', description: 'Which Component To Deploy?')
      string(name: 'VERSION', defaultValue: '', description: 'Which Version To Deploy?')
      string(name: 'ENV', defaultValue: '', description: 'Which Environment To Deploy?')
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