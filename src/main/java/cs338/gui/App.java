/*
 * App.java
 * cs338-gui
 * Drexel University - CS338 
 * 
 * Author: Matthew Dey
 * Date Created: 
 * 
 * App.java is the driver of the program.
 * 
 */
package cs338.gui;

import javax.swing.SwingUtilities;

public class App {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}