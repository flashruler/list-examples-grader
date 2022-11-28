# Create your grading script here
PTH=".;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar"
rm -rf student-submission
git clone $1 student-submission
cd student-submission
if test -f ListExamples.java
then
    cp -v ListExamples.java ../
else 
    echo "incorrect file, please use the correct naming/formatting"
    exit
fi
cd .. 
javac -cp $PTH *.java 2> compile_error.txt

if [[ $? -ne 0 ]]
then
    echo "Failed to compile."
    cat compile_error.txt
    exit 1
else
    echo "Sucessfully compiled..."
fi

java -cp $PTH org.junit.runner.JUnitCore TestListExamples > Result.txt
grep "Tests run:" < Result.txt > ResultScore.txt
PASSED=`wc -l ResultScore.txt | grep -o '[0-9]'`
VARS=(`grep -Eo '[0-9]{1,2}' < resultScore.txt`)
TOTAL_TESTS=${VARS[0]}
FAILURES=${VARS[1]}
SUCCESS=$(($TOTAL_TESTS-$FAILURES))

if [[ $TOTAL_TESTS -eq $SUCCESS ]]
then
    echo "7/7 tests passed."
else
    echo "error"
    echo "$(($TOTAL_TESTS-$FAILURES))/7 tests passed."
fi
cat result.txt

