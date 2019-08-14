package cs338.gui.ribbon;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class RibbonSizeView extends JPanel {

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