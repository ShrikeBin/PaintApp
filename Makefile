all: build run

build:
	javac --module-path ../javaFX/lib --add-modules javafx.controls PaintApp.java

run:
	java --module-path ../javaFX/lib --add-modules javafx.controls PaintApp

clean:
	rm -rf *.class
	rm log.txt