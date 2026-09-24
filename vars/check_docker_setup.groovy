def call() {
  echo "=== Checking Docker Status ==="
                sh '''
                    if command -v docker >/dev/null 2>&1; then
                        echo "Success: Docker is already installed."
                        docker --version
                    else
                        echo "Docker not found. Running official installation..."
                        
                        # Purane conflict karne wale tools hatana
                        sudo apt remove -y $(dpkg --get-selections docker.io docker-compose docker-compose-v2 docker-doc docker-buildx podman-docker containerd runc 2>/dev/null | cut -f1) || true
                        
                        # Official GPG keys aur setup
                        sudo apt update
                        sudo apt install -y ca-certificates curl
                        sudo install -m 0755 -d /etc/apt/keyrings
                        sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
                        sudo chmod a+r /etc/apt/keyrings/docker.asc

                        # Official Repository list banana (Deb822 style)
                        sudo tee /etc/apt/sources.list.d/docker.sources <<EOF
Types: deb
URIs: https://download.docker.com/linux/ubuntu
Suites: \$(. /etc/os-release && echo "\${UBUNTU_CODENAME:-\$VERSION_CODENAME}")
Components: stable
Architectures: \$(dpkg --print-architecture)
Signed-By: /etc/apt/keyrings/docker.asc
EOF

                        sudo apt update
                        sudo apt install -y docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
                        
                        # Permissions dena taaki Jenkins pipeline error na kare
                        sudo usermod -aG docker \$USER
                        sudo systemctl enable docker
                        sudo systemctl start docker
                    fi
                '''
  }
