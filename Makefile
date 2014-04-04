

all:
	find src -name "*.java" | grep -vi test | xargs javac -cp src -d bin

test:
	find src -name "*.java" | xargs javac -cp src:/usr/share/java/junit4.jar -d bin
	java -cp /usr/share/java/junit4.jar:bin org.junit.runner.JUnitCore MathExTest

