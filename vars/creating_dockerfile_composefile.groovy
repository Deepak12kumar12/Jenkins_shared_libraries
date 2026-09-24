def call() {
  echo 'This is show list directory inside the workspace/My_project_pipeline/'
                sh '''
                ls -la
                if [ -d "Shopping_Website_Project" ]; then 
                echo "The file and folder is present in agent_2 directory"
               
                echo "Creating Dockerfile"
                cat << 'EOF' > Dockerfile
FROM php:8.2-apache
RUN docker-php-ext-install mysqli
WORKDIR /var/www/html
COPY Shopping_Website_Project/ .
EXPOSE 80
CMD ["apache2-foreground"]
EOF
                
                echo "Creating Docker compose file"
                cat << 'EOF' > docker-compose.yml
services:
 web:
  build: .
  container_name: shopping_website
  ports:
   - "9080:80"
  depends_on:
   - db

 db:
  image: mysql:8.0
  environment:
   MYSQL_ROOT_PASSWORD: root
   MYSQL_DATABASE: user_ragister
  volumes:
   - mysql_data:/var/lib/mysql
   - ./user_ragister.sql:/docker-entrypoint-initdb.d/user_ragister.sql

volumes:
  mysql_data:
EOF
                echo "Both Dockerfile and docker-compose.yml created successfully!"
                else
                echo "Shopping Website Project folder is not present"
                exit 1
                fi
                '''
}
