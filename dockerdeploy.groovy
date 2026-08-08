def call(String imageName, String containerName, String port) {
echo "Deploying Docker container..."

sh """
    docker rm -f ${containerName} || true

    docker run -d \
        --name ${containerName} \
        --env-file .env \
        -p ${port}:8000 \
        ${imageName}
"""


}
