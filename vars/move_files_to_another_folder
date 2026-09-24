def call() {
echo 'Creating folder and moving all files inside it...'
sh '''
# 1. Pehle check karega ki kya folder pehle se bana hai, nahi to banayega
mkdir -p Shopping_Website_Project
# 2. Jenkins ki files ko chhor kar, baaki saari files ko naye folder me move karega
find . -maxdepth 1 -not -name '.' -not -name '..' -not -name 'Shopping_Website_Project' -not -name '@tmp' -exec mv {} Shopping_Website_Project/ \\;
echo "--- Current Directory Structure After Move ---"
ls -la
echo "--- Inside Shopping_Website_Project ---"
ls -la Shopping_Website_Project/
'''
}
