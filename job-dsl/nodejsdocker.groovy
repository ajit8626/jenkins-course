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
          repositoryName('nodejs44')
          tag('${GIT_REVISION,length=7}')
          registryCredentials('docker creds')
          forcePull(false)
          createFingerprints(false)
          skipDecorate()
        }
    }
}
