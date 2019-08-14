package cs338.gui.ribbon;

import cs338.gui.subwindows.BrushSizeWindowView;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class RibbonBrushesView extends JPanel {

    private JButton brushes;

    RibbonBrushesView() {
        super();
        this.setLayout(new BorderLayout());
        initComponents();
    }

    public void initComponents() {

        // component instantiation
        brushes = new JButton("Brushes");
        brushes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BrushSizeWindowView bsw = new BrushSizeWindowView();
            }
        });

    // add components
    this.add(brushes, BorderLayout.CENTER);
    }

}