/*
 * MainFrame.java
 * cs338-gui
 * Drexel University - CS338
 * 
 * Author: Matthew Dey
 * Date Created: 
 * 
 * MainFrane.java is the main GUI frame for the application.
 * 
 */

package cs338.gui;

import javax.swing.*;
import java.util.logging;

 public class MainFrame {

    JFrame frame;
    JButton button;

    MainFrame(int width, int length, String framename, String buttonname) {
        this.frame = new JFrame(framename);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(width,length);
        this.button = new JButton(buttonname);
        this.frame.getContentPane().add(button);
    }

    public void run() {
        this.frame.setVisible(true);
        return;
    }
}