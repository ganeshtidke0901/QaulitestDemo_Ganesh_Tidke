pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'hello'
      }
    }

    stage('test') {
      parallel {
        stage('test') {
          steps {
            echo 'hello test'
            build 'freestyle'
          }
        }

        stage('integration test') {
          steps {
            echo 'echo'
          }
        }

        stage('perfomance test') {
          steps {
            timeout(time: 10, activity: true) {
              echo 'echo'
            }

          }
        }

      }
    }

    stage('deploy') {
      steps {
        echo 'deployindg'
      }
    }

  }
}
