package cs338.gui.ribbon;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import cs338.gui.subwindows.BrushSizeWindowView;

public class RibbonBrushView extends JPanel {

    private static final long serialVersionUID = 1L;
    JButton pencilSize, brushes;

    RibbonBrushView() {
        super();
        this.setLayout(new BorderLayout());
        initComponents();
    }

    public void initComponents() {

        JPanel inner_brushes = new JPanel(new GridLayout(2, 1, 10, 10));

        // init labels
        JLabel brushes_label = new JLabel("Brush", SwingConstants.CENTER);

        // init button
        pencilSize = new JButton("Size");
        pencilSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BrushSizeWindowView bsw = new BrushSizeWindowView();
                bsw.setVisible(true);
            }
        });

        // component instantiation
        brushes = new JButton("Brushes");
        brushes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BrushSizeWindowView bsw = new BrushSizeWindowView();
                bsw.setVisible(true);
            }
        });

        inner_brushes.add(pencilSize);
        inner_brushes.add(brushes);

        // add components
        this.add(inner_brushes, BorderLayout.CENTER);
        this.add(brushes_label, BorderLayout.SOUTH);
        
    }

}