package cs338.gui.subwindows;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ResizeWindowView extends JFrame {

    private static final long serialVersionUID = 1L;
    JPanel resizePanel;
    JLabel byLabel, horizontalLabel,verticalLabel;
    JTextField horField, vertField;
    JButton okButton, cancelButton;

    ResizeWindowView() {
        super();
        this.setName("Resize Canvas");
        this.setLayout(new BorderLayout());
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