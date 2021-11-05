job('nodejs') {
    scm {
        git {
            remote {
                github('https://github.com/ajit8626/jenkins-course.git', 'https')
                credentials('Git creds')
            }
        }
    }
    wrappers {
    	nodejs('nodejs')
    }
   steps {
      dockerBuildAndPublish {
          repositoryName('ab8626/project-a')
          tag('${BUILD_TIMESTAMP}-${GIT_REVISION,length=7}')
          registryCredentials('docker creds')
          forcePull(false)
          createFingerprints(false)
          skipDecorate()
        }
    }
}
