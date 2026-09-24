def call() {
  echo "=== Verifying Services ==="
                sh '''
                    # Yahan 'status' ki jagah 'is-active' use kiya hai taaki pipeline freeze na ho
                    sudo systemctl is-active docker
                    docker --version
                    docker compose version
                '''
}
