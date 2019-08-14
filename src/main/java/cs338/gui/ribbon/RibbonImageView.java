package cs338.gui.ribbon;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RibbonImageView extends JPanel {

    JPanel inner_image;
    JButton select, crop, rotate, resize;

    RibbonImageView() {
        super();
        this.setLayout(new BorderLayout());
        initComponents();
    }

    public void initComponents() {
        // init inner panel
        inner_image = new JPanel();
        inner_image.setLayout(new BoxLayout(inner_image, BoxLayout.Y_AXIS));

        // init label
        JLabel imageLabel = new JLabel("Image", SwingConstants.CENTER);

        // init buttons
        select = new JButton("Select");
        crop = new JButton("Crop");
        resize = new JButton("Resize");
        rotate = new JButton("Rotate");

        // add components
        inner_image.add(crop);
        inner_image.add(resize);
        inner_image.add(rotate);

        this.add(select, BorderLayout.CENTER);
        this.add(inner_image, BorderLayout.EAST);
        this.add(imageLabel, BorderLayout.SOUTH);
        
    }

}