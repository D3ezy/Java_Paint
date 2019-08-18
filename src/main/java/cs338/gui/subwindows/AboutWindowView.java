package cs338.gui.subwindows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class AboutWindowView extends JFrame {

    private static final long serialVersionUID = 1L;
    JPanel authorPanel, aboutPanel, buttonPanel;
    JButton okButton;
    JSeparator topbottomSep;
    JTextArea info, author;

    public AboutWindowView() {
        super();
        this.setPreferredSize(new Dimension(400,350));
        this.setMinimumSize(new Dimension(400,350));
        this.setLayout(new BorderLayout());
        initComponents();
        this.setName("About Java Paint");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void initComponents() {
        authorPanel = new JPanel(new BorderLayout());
        aboutPanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel(new FlowLayout());

        okButton = new JButton("OK");
        return;
    }

}