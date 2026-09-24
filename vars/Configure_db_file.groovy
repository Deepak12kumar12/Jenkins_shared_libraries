def call() {
  echo 'Updating db.php files for making connection to Mysql Database.'
  sh '''
  if [ -f "Shopping_Website_Project/db.php" ]; then
  # sed command se localhost:3306 ko badal kar db kar rahe hain
  sed -i 's/localhost:3306/db/g' Shopping_Website_Project/db.php
  echo "db.php successfully file change."
                    
  echo "--- Updated db.php Content Preview ---"
  cat Shopping_Website_Project/db.php
  else
  echo "Error: db.php file not found inside the project folder!"
  exit 1
  fi
  '''
}
