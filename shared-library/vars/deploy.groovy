def call() {
  pipeline {
    agent any

    options {
      ansiColor ('xterm')
    }

    parameters {
      string(name: 'COMPONENT', defaultValue: '', description: 'Which Component to Deploy?')
      string(name: 'VERSION', defaultValue: '', description: 'Which Version to Deploy?')
      string(name: 'ENV', defaultValue: '', description: 'Which Environment to Deploy?')
    }

    environment {
      SSH = credentials('centos-ssh')
    }

    stages {

      stage ('Compile') {
        echo 'OK'
      }

    }

  }
}