package cs338.gui.ribbon;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Dimension;

public class RibbonView extends JPanel {
    
    private static final long serialVersionUID = 1L;

    public RibbonView() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        initComponents();
    }

    public void initComponents() {
        // Component Instantiation
        RibbonClipboardView clipboard = new RibbonClipboardView();
        RibbonImageView image = new RibbonImageView();
        RibbonToolsView tools = new RibbonToolsView();
        RibbonShapesView shapes = new RibbonShapesView();
        RibbonBrushView size = new RibbonBrushView();
        RibbonColorChooserView color_chooser = new RibbonColorChooserView();

        // Separators
        JSeparator rib_sep1 = new JSeparator(SwingConstants.VERTICAL);
        JSeparator rib_sep2 = new JSeparator(SwingConstants.VERTICAL);
        JSeparator rib_sep3 = new JSeparator(SwingConstants.VERTICAL);
        JSeparator rib_sep5 = new JSeparator(SwingConstants.VERTICAL);
        JSeparator rib_sep6 = new JSeparator(SwingConstants.VERTICAL);
        JSeparator rib_sep7 = new JSeparator(SwingConstants.VERTICAL);
   
        // Main Ribbon
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(clipboard);                                    // Clipboard
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(rib_sep1);                                     // Separator
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(image);                                        // Image
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(rib_sep2);                                     // Separator
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(tools);                                        // Tools
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(rib_sep3);                                     // Separator
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(shapes);                                       // Shapes Selector
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(rib_sep5);                                     // Separator
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(size);                                         // Pencil Size
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(rib_sep6);                                     // Separator
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(color_chooser);                                // Color Panel
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(rib_sep7);                                     // Separator  
        return;
    }

}