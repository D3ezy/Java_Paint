package cs338.gui;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;

public class BrushSizeWindow extends JFrame {

    private JPanel brushPanel;

    BrushSizeWindow() {
        initComponents();
    }

    public void initComponents() {
        brushPanel = new JPanel(new BoxLayout(brushPanel, BoxLayout.Y_AXIS)); 

        this.setTitle("Change Brush Size");
        this.setPreferredSize(new Dimension(400,400));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
    }
}