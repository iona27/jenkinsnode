job('App-Nodejs-Docker-DSL') {
    description('Aplicación Node JS Docker DSL para el curso de Jenkins y run.sh')
    scm {
        git('https://github.com/iona27/jenkinsnode.git', 'master'){ node -> 
            node / gitConfigName('iona27')
            node / gitConfigEmail('pillancariona@gmail.com')
        }
    }
    triggers {
        githubPush()
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('dockeriona/jenkins-dsl')
            tag('${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}