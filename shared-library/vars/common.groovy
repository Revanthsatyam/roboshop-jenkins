def compile() {

  if (env.codeType == "python" || env.codeType == "static") {
    return "Return, Do not need Compilation"
  }

  stage('Compile Code') {

    if (env.codeType == "maven")  {
      sh '/home/centos/maven/bin/mvn package'
    }

    if (env.codeType == "nodejs") {
      sh 'npm install'
    }
  }

}

def test() {
  stage('Test Cases') {

    if (env.codeType == "maven") {
      //sh '/home/centos/maven/bin/mvn test'
      print 'OK'
    }

    if (env.codeType == "nodejs") {
      //sh 'npm test'
      print 'OK'
    }

    if (env.codeType == "python") {
      //sh 'python3.6 -m unittest'
      print 'OK'
    }

  }
}

def codeQuality() {
  stage('Code Quality') {
    env.sonaruser = sh (script: 'aws ssm get-parameter --name "sonarqube.user" --with-decryption --query="Parameter.Value" |xargs', returnStdout: true).trim()
    env.sonarpass = sh (script: 'aws ssm get-parameter --name "sonarqube.password" --with-decryption --query="Parameter.Value" |xargs', returnStdout: true).trim()
    wrap([$class: "MaskPasswordsBuildWrapper", varPasswordPairs: [[password: sonarpass]]]) {
      if (env.codeType == "maven") {
        sh 'sonar-scanner -Dsonar.host.url=http://44.212.32.139:9000 -Dsonar.login=${sonaruser} -Dsonar.password=${sonarpass} -Dsonar.projectKey=${component} -Dsonar.qualitygate.wait=true -Dsonar.java.binaries=./target'
      }else {
        sh 'sonar-scanner -Dsonar.host.url=http://44.212.32.139:9000 -Dsonar.login=${sonaruser} -Dsonar.password=${sonarpass} -Dsonar.projectKey=${component} -Dsonar.qualitygate.wait=true'
      }
    }
  }
}

def codeSecurity() {
  stage('Code Security') {
    print 'Code Security'

    // IN code security we will generally used SAST & SCA checks
    // You can say that your company is using checkmarx sast and checkmarx sca for this,
  }
}

def release() {
  stage('Release') {
    print 'Release'
  }
}