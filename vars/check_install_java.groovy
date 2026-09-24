def call(){
  echo "=== Checking Java Status ==="
                sh '''
                    if command -v java >/dev/null 2>&1; then
                        echo "Success: Java is already installed."
                        java -version
                    else
                        echo "Java not found. Installing OpenJDK 21..."
                        sudo apt update
                        sudo apt install -y fontconfig openjdk-21-jre
                        java -version
                    fi
                '''
}
