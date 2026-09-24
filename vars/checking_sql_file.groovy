def call() {
  echo 'Checking the user_ragister.sql file is right place'
  sh '''
  if ls *.sql >/dev/null 2>&1; then
  echo "user_ragister.sql file is present"
  else
  cp Shopping_Website_Project/*.sql .
  echo "user_ragister.sql file copying successfully"
  fi
  '''
}
