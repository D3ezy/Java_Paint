package cs338.gui.ribbon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;
import cs338.gui.MainFrame;
import cs338.gui.canvas.Tool;

public class RibbonShapesView extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    JPanel inner_shapes, comboBoxPanel;
    JButton shapeOutline, shapeFill;
    JComboBox<Tool> shapes;
    Tool[] items = {Tool.LINE, Tool.RECTANGLE, Tool.OVAL};

    RibbonShapesView() {
        super();
        this.setLayout(new BorderLayout(10,10));
        initComponents();
        prepareIcons();
    }

    public void initComponents() {

        // init panels
        inner_shapes = new JPanel(new BorderLayout());
        comboBoxPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // BoxLayout inner_shapes_layout = new BoxLayout(inner_shapes, BoxLayout.Y_AXIS);
        // inner_shapes.setLayout(inner_shapes_layout);

        // init labels
        JLabel shapesLabel = new JLabel("Shapes", SwingConstants.CENTER);

        // init buttons
        shapes = new JComboBox<Tool>(items);
        shapes.setToolTipText("Changes the type of shape to draw");
        shapeOutline = new JButton("Outline");
        shapeOutline.setToolTipText("Changes shape outline color (NOT WORKING)");
        shapeFill = new JButton("Fill   ");
        shapeFill.setToolTipText("Changes the fill in color of shape (NOT WORKING)");
        shapeFill.setPreferredSize(shapeOutline.getPreferredSize());

        shapes.addActionListener(this);
        shapeOutline.addActionListener(this);
        shapeFill.addActionListener(this);
        this.shapes.setPreferredSize(new Dimension(100,40));

        // add components
        inner_shapes.add(shapeOutline, BorderLayout.NORTH);
        inner_shapes.add(shapeFill, BorderLayout.SOUTH);
        comboBoxPanel.add(shapes);

        this.add(inner_shapes, BorderLayout.CENTER);
        this.add(comboBoxPanel, BorderLayout.NORTH);
        this.add(shapesLabel, BorderLayout.SOUTH);
    }

    private void prepareIcons() {
        FontIcon shapeOutline_icon = FontIcon.of(FontAwesomeSolid.OUTDENT, Color.BLACK);
        FontIcon shapeFill_icon = FontIcon.of(FontAwesomeSolid.PAINT_BRUSH, Color.BLACK);
        shapeOutline.setIcon(shapeOutline_icon);
        shapeFill.setIcon(shapeFill_icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == shapes) {
            Tool t = (Tool) this.shapes.getSelectedItem();
            RibbonView.tools.shape.setSelected(true);
            MainFrame.canvas.setCurrentTool(t);
        } else if (e.getSource() == shapeOutline) {

        } else if (e.getSource() == shapeFill) {

        }
	}

}