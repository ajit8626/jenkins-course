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
            repositoryName('ab8626/docker-nodejs-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockercreds')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
