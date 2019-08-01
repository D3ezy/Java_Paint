package cs338.gui;

import java.awt.BorderLayout;

import javax.swing.*;

public class MainFrame extends JFrame {

    
    public MainFrame() {
        initComponents();
    }

    private void initComponents() {
        JButton test1 = new JButton("Click Me! South");
        JButton test2 = new JButton("Click Me! North");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add(test1, BorderLayout.SOUTH);
        panel.add(test2, BorderLayout.NORTH);

        pack();
    }
}
