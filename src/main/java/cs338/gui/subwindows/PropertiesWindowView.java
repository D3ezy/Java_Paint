package cs338.gui.subwindows;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PropertiesWindowView extends JFrame {

    private static final long serialVersionUID = 1L;
    JPanel fileAttributesPanel, buttonsPanel;
    JButton okButton, cancelButton, defaultButton;
    JTextField widthTextField, heightTextField;
    JLabel widthLabel, heightLabel, lastSavedLabel, sizeOnDiskLabel;

    public PropertiesWindowView() {
        super();
        this.setPreferredSize(new Dimension(400,350));
        this.setMinimumSize(new Dimension(400,350));
        this.setLayout(new BorderLayout());
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setName("Image Properties");
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void initComponents() {
        fileAttributesPanel = new JPanel();
        defaultButton = new JButton("Default");
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        widthTextField = new JTextField();
        heightTextField = new JTextField();
        widthLabel = new JLabel("Width");
        heightLabel = new JLabel("Height");
        lastSavedLabel = new JLabel("Last Saved:");
        sizeOnDiskLabel = new JLabel("Size on disk");

    }

}