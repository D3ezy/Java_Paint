# cs338-gui
GUI Project for CS338 - Summer Term 2019 @ Drexel University

Matthew Dey
CS 338 - Project Stage 3
Java Paint v0.9
GitHub: https://github.com/D3ezy/cs338-gui

:: Credit to Dependencies

Java Tutorials were Followed for Learning how to Paint on JPanel:
https://docs.oracle.com/javase/tutorial/uiswing/painting/

Open Source Icons were used from imported dependency Ikonli:
http://aalmiray.github.io/ikonli/#_fontawesome

:: TO RUN

java -jar .\build\libs\JavaPaint-0.1.jar

This program is packaged into a JAR file that is built with gradle. All dependencies should be pre-packaged into the JAR. Sample documents are provided in the ./Documents folder and can be used to test
saving/loading from file. If the JAR file will not run you can run the gradle task (it is installed on TUX) to create a new executable JAR:

In the root project directory:

gradle clean
gradle shadowJar
java -jar .\build\libs\JavaPaint-0.1.jar

The program has many features implemented, some with bugs. The information is listed below.

:: FEATURES

What works properly:

- Selecting a color
- Advanced color selection
- Freehand Drawing
- Changing Brush size
- Changing brush type
- Saving
- Loading
- Undo
- Redo
- Drawing Rectangles on canvas
- Bottom infobar pointer update
- Bottom infobar canvas size
- Eraser Tool
- New file prompt (This file has not been saved, would you like to?)
- painting textbox on screen
- Keyboard shortcuts
- Resizing the canvas
- Zooming in on the canvas (partially)


:: PROBLEMS
- Rotate

To be done (after term): 

- Outline/Fill
- Clean up subwindows
- Add more font and shape options
- Add more brush size options
- Add Tool Tips where needed