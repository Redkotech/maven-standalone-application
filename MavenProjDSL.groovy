job('mydsl-project') {
  displayName('maven-DSL-project')
  description('Builds and deploys a Maven project')

  scm {
    git {
      remote {
        url('https://github.com/Redkotech/maven-standalone-application.git')
        //credentials('github-credentials')
      }
      branch('master')
    }
  }

  triggers {
    scm('* * * * *')
  }

  steps {
    maven {
      goals('clean package')
      //mavenInstallation('Maven 3.6.3')
      rootPOM('pom.xml')
      injectBuildVariables(true)
    }
  }

  publishers {
    archiveArtifacts('**/*jar')
    archiveJunit('**/target/surefire-reports/TEST-*.xml')
  }

/*  postBuild {
    always {
      emailext {
        recipientProviders {
          developers()
        }
        subject('Build Notification - ${PROJECT_NAME} - Build #${BUILD_NUMBER} - ${BUILD_STATUS}')
        body('''
          <p>Build Information:</p>
          <ul>
            <li>Project: ${PROJECT_NAME}</li>
            <li>Build Number: ${BUILD_NUMBER}</li>
            <li>Status: ${BUILD_STATUS}</li>
          </ul>
        ''')
      }
    }
  }*/
}
