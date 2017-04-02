node("jenkinsdockerslave1") {
    docker.withRegistry('https://registry.hub.docker.com', 'docker-credentials') {
        docker.withServer('tcp://172.17.0.1:4243') {
    
            git url: "https://github.com/bschalme/qbd-api.git", credentialsId: 'github-credentials'
    
            sh "git rev-parse HEAD > .git/commit-id"
            def commit_id = readFile('.git/commit-id').trim()
            println commit_id
    
            def app
            stage("Build") {
                sh "./gradlew build"
                app = docker.build "bschalme/qbd-api"
            }
    
            stage("Publish") {
                app.push("latest")
                app.push "${commit_id}"
            }
        }
    }
}