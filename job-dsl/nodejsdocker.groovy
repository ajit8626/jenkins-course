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
      cleanWs()
      dockerBuildAndPublish {
          repositoryName('nodejs34')
          tag('${GIT_REVISION,length=10}')
          registryCredentials('dockercreds')
          forcePull(false)
          createFingerprints(false)
          skipDecorate()
        }
    }
}
