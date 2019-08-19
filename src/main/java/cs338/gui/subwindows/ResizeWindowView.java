package cs338.gui.subwindows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import cs338.gui.MainFrame;

public class ResizeWindowView extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    JPanel resizePanel, buttonsPanel;
    JLabel horizontalLabel,verticalLabel;
    JTextField horField, vertField;
    JButton okButton, cancelButton;

    public ResizeWindowView() {
        super();
        this.setName("Resize Canvas");
        this.setLayout(new BorderLayout());
        initComponents();
        prepareIcons();
        this.setPreferredSize(new Dimension(400,300));
        this.setMinimumSize(new Dimension(400,300));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void initComponents() {
        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        resizePanel = new JPanel();
        resizePanel.setLayout(new GridLayout(2,2));
        horizontalLabel = new JLabel("Horizontal:");
        verticalLabel = new JLabel("Vertical:");
        horField = new JTextField();
        vertField = new JTextField();
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        okButton.addActionListener(this);
        cancelButton.addActionListener(this);

        resizePanel.add(horizontalLabel);
        resizePanel.add(verticalLabel);
        resizePanel.add(horField);
        resizePanel.add(vertField);
        buttonsPanel.add(okButton);
        buttonsPanel.add(cancelButton);
        this.add(resizePanel, BorderLayout.NORTH);
        this.add(buttonsPanel, BorderLayout.SOUTH);
    }

    public void prepareIcons() {
        FontIcon horIcon = FontIcon.of(FontAwesomeSolid.TEXT_WIDTH, Color.BLACK);
        FontIcon vertIcon = FontIcon.of(FontAwesomeSolid.TEXT_HEIGHT, Color.BLACK);
        this.horizontalLabel.setIcon(horIcon);
        this.verticalLabel.setIcon(vertIcon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            int horizontal = Integer.parseInt(this.horField.getText());
            int vertical = Integer.parseInt(this.vertField.getText());
            Dimension newDim = new Dimension(horizontal, vertical);
            MainFrame.canvas.updateCanvasSize(newDim);
            this.dispose();
        } else if (e.getSource() == cancelButton) {
            this.dispose();
        }
	}

}