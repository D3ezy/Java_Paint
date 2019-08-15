package cs338.gui.ribbon;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

public class RibbonImageView extends JPanel {

    private static final long serialVersionUID = 1L;
    JPanel inner_image;
    JButton select, crop, rotate, resize;

    RibbonImageView() {
        super();
        this.setLayout(new BorderLayout());
        initComponents();
        prepareIcons();
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

    private void prepareIcons() {
        FontIcon select_icon = FontIcon.of(FontAwesomeSolid.EXPAND, Color.BLACK);
        FontIcon crop_icon = FontIcon.of(FontAwesomeSolid.CROP, Color.BLACK);
        FontIcon resize_icon = FontIcon.of(FontAwesomeSolid.CLONE, Color.BLACK);
        FontIcon rotate_icon = FontIcon.of(FontAwesomeSolid.RETWEET, Color.BLACK);
        select.setIcon(select_icon);
        crop.setIcon(crop_icon);
        resize.setIcon(resize_icon);
        rotate.setIcon(rotate_icon);
    }

}