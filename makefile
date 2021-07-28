Main.class:
	javac -Xlint  *.java

clean:
	rm -f *.class

run:Main.class
	java -Xmx64m Main