def call() {
  echo 'Starting the docker-compose deployment'
                sh '''
                echo "Removing old containers and volumes..."
                sudo docker compose down --volumes --remove-orphans
                echo "Building new images and starting containers..."
                sudo docker compose up -d --build
                echo "Checking Container status..."
                sudo docker compose ps
                '''
                echo 'Your Shopping Website is Running Successfully '
}
