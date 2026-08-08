  def call(String imageName, String repository) {

withCredentials([
    usernamePassword(
        credentialsId: 'dockerHub',
        usernameVariable: 'dockerHubUser',
        passwordVariable: 'dockerHubPass'
    )
]) {

    sh """
        docker login -u "\$dockerHubUser" -p "\$dockerHubPass"
        docker tag ${imageName} "\$dockerHubUser/${repository}:latest"
        docker push "\$dockerHubUser/${repository}:latest"
    """
}

}
