job('nodejs') {
    scm {
         git('git://github.com/wardviaene/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
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
