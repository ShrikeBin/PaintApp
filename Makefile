all: build run

build:
	javac --module-path ./lib --add-modules javafx.controls App/*.java

run:
	java --module-path ./lib --add-modules javafx.controls -cp ./App PaintApp

clean:
	rm -rf App/*.class
	rm -f log.txt
