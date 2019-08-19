package cs338.gui.subwindows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class AboutWindowView extends JFrame {

    private static final long serialVersionUID = 1L;
    private final static String newline = "\n";
    JPanel authorPanel, aboutPanel, buttonPanel;
    JButton okButton;
    JSeparator topbottomSep;
    JTextArea info, author;

    public AboutWindowView() {
        super();
        this.setPreferredSize(new Dimension(400,350));
        this.setMinimumSize(new Dimension(400,350));
        initComponents();
        this.setTitle("About Java Paint");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void initComponents() {
        authorPanel = new JPanel(new BorderLayout());
        aboutPanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        topbottomSep = new JSeparator(SwingConstants.HORIZONTAL);
        author = new JTextArea("Author: Matthew Dey" +newline +"Email: mjd427@drexel.edu" +newline + "GitHub: https://github.com/D3ezy/cs338-gui");
        info = new JTextArea("This application was developed for Drexel University class " + newline + "CS338 - Graphical User Interfaces. Developed in " +newline+
                                                 "Java Swing - Java JDK Version 8");
        author.setEditable(false);
        info.setEditable(false);

        okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
			}

        });

        buttonPanel.add(okButton);

        this.add(author);
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(topbottomSep);
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(info);
        this.add(Box.createRigidArea(new Dimension(20,0)));
        this.add(buttonPanel);
        return;
    }

}