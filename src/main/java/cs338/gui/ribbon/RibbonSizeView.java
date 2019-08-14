package cs338.gui.ribbon;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class RibbonSizeView extends JPanel {

    private static final long serialVersionUID = 1L;
    JButton pencilSize;

    RibbonSizeView() {
        super();
        this.setLayout(new BorderLayout());
        initComponents();
    }

    public void initComponents() {

        // init button
        pencilSize = new JButton("Size");

        // add components
        this.add(pencilSize, BorderLayout.CENTER);
    }

}