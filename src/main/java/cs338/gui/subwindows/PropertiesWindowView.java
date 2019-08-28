package cs338.gui.subwindows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import cs338.gui.MainFrame;

public class PropertiesWindowView extends JFrame {

    private static final long serialVersionUID = 1L;
    JPanel fileAttributesPanel, buttonsPanel, resizePanel;
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
        fileAttributesPanel = new JPanel(new GridLayout(2, 2));
        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        resizePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        defaultButton = new JButton("Default");
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        widthTextField = new JTextField(Double.toString(MainFrame.canvas.getPreferredSize().getWidth()));
        heightTextField = new JTextField(Double.toString(MainFrame.canvas.getPreferredSize().getHeight()));
        widthLabel = new JLabel("Width:");
        heightLabel = new JLabel("Height:");
        lastSavedLabel = new JLabel("Last Saved:");
        sizeOnDiskLabel = new JLabel("Size on disk");

        defaultButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension def = MainFrame.canvas.getPreferredSize();
                MainFrame.canvas.setSize(def);
                widthTextField.setText(Double.toString(def.getWidth()));
                heightTextField.setText(Double.toString(def.getHeight()));
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Dimension newDim = null;
            try {
                int horizontal = Integer.parseInt(widthTextField.getText());
                int vertical = Integer.parseInt(heightTextField.getText());
                newDim = new Dimension(horizontal, vertical);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please use numbers as input.");
            }
                MainFrame.canvas.updateCanvasSize(newDim);
			}
            
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
            
        });

        fileAttributesPanel.add(lastSavedLabel);
        fileAttributesPanel.add(sizeOnDiskLabel);

        resizePanel.add(this.widthLabel);
        resizePanel.add(this.widthTextField);
        resizePanel.add(this.heightLabel);
        resizePanel.add(this.heightTextField);
        resizePanel.add(this.defaultButton);

        buttonsPanel.add(okButton);
        buttonsPanel.add(cancelButton);

        this.add(buttonsPanel, BorderLayout.SOUTH);
        this.add(resizePanel, BorderLayout.CENTER);
        this.add(fileAttributesPanel, BorderLayout.NORTH);

    }

}