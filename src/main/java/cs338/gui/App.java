/*
 * App.java
 * cs338-gui
 * Drexel University - CS338 
 * 
 * Author: Matthew Dey
 * Date Created: 
 * 
 * App.java is the driver for the program.
 * 
 */
package cs338.gui;

public class App {

    public static void main(String[] args) {
        MainFrame mf = new MainFrame(300,300, "My Test App", "Press here!");
        mf.run();
    }
}
