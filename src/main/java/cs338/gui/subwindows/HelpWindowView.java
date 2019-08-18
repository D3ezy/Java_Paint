package cs338.gui.subwindows;

import java.awt.Dimension;

import javax.swing.JFrame;

public class HelpWindowView extends JFrame {

    private static final long serialVersionUID = 1L;

    public HelpWindowView() {
        super();
        initComponents();
        this.setPreferredSize(new Dimension(400,300));
        this.setMinimumSize(new Dimension(400,300));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void initComponents() {

    }

}