package cs338.gui.ribbon;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RibbonColorChooserView extends JPanel {

    private JButton openChooser, currColor;
    private JColorChooser pallette;

    RibbonColorChooserView() {
        super();
        this.setLayout(new BorderLayout());
        initComponents();
    }

    public void initComponents() {

        // Labels
        JLabel colorsLabel = new JLabel("Colors", SwingConstants.CENTER);

        //  Color Pallette
        openChooser = new JButton("Open Color Chooser");
        pallette = new JColorChooser(Color.BLACK);
        pallette.setPreviewPanel(new JPanel());
        currColor = new JButton(pallette.getName());

        // add components
        this.add(currColor, BorderLayout.WEST);
        this.add(colorsLabel, BorderLayout.SOUTH);
        this.add(openChooser, BorderLayout.CENTER);
    }

}