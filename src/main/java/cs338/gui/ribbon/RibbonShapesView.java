package cs338.gui.ribbon;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RibbonShapesView extends JPanel {

    JPanel inner_shapes;
    JButton shapes, shapeOutline, shapeFill;

    RibbonShapesView() {
        super();
        this.setLayout(new BorderLayout());
        initComponents();
    }

    public void initComponents() {

        // init panels
        inner_shapes = new JPanel();
        BoxLayout inner_shapes_layout = new BoxLayout(inner_shapes, BoxLayout.Y_AXIS);
        inner_shapes.setLayout(inner_shapes_layout);

        // init labels
        JLabel shapesLabel = new JLabel("Shapes", SwingConstants.CENTER);

        // init buttons
        shapes = new JButton("Shapes");
        shapeOutline = new JButton("Outline");
        shapeFill = new JButton("Fill");

        // add components
        inner_shapes.add(shapeOutline);
        inner_shapes.add(shapeFill);

        this.add(shapes, BorderLayout.CENTER);
        this.add(inner_shapes, BorderLayout.EAST);
        this.add(shapesLabel, BorderLayout.SOUTH);
    }

}