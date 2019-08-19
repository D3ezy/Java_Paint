package cs338.gui.ribbon;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

public class RibbonShapesView extends JPanel {

    private static final long serialVersionUID = 1L;
    JPanel inner_shapes;
    JButton shapeOutline, shapeFill;
    JList<JButton> shapes;

    RibbonShapesView() {
        super();
        this.setLayout(new BorderLayout());
        initComponents();
        prepareIcons();
    }

    public void initComponents() {

        // init panels
        inner_shapes = new JPanel();
        BoxLayout inner_shapes_layout = new BoxLayout(inner_shapes, BoxLayout.Y_AXIS);
        inner_shapes.setLayout(inner_shapes_layout);

        // init labels
        JLabel shapesLabel = new JLabel("Shapes", SwingConstants.CENTER);

        // init buttons
        shapes = new JList<>();
        shapes.add(new JButton("line"));
        shapes.add(new JButton("square"));
        shapes.add(new JButton("freehand"));
        shapeOutline = new JButton("Outline");
        shapeFill = new JButton("Fill");

        // add components
        inner_shapes.add(shapeOutline);
        inner_shapes.add(shapeFill);

        this.add(shapes, BorderLayout.CENTER);
        this.add(inner_shapes, BorderLayout.EAST);
        this.add(shapesLabel, BorderLayout.SOUTH);
    }

    private void prepareIcons() {
        FontIcon shapeOutline_icon = FontIcon.of(FontAwesomeSolid.OUTDENT, Color.BLACK);
        FontIcon shapeFill_icon = FontIcon.of(FontAwesomeSolid.PAINT_BRUSH, Color.BLACK);
        shapeOutline.setIcon(shapeOutline_icon);
        shapeFill.setIcon(shapeFill_icon);
    }

}