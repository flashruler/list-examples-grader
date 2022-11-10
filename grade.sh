# Create your grading script here

set -e
rm -rf student-submission
git clone $1 student-submission
cd student-submission
ls
echo "we are in student-submission"
if test -f ListExamples.java
then
    echo "this file exists"
    cp -v ListExamples.java ../
else 
    echo "incorrect file, please use the name ListExamples.java"
    exit
fi
cd .. 
echo "back in parent dir"

javac -cp lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java
echo "compiled"

java -cp lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples


