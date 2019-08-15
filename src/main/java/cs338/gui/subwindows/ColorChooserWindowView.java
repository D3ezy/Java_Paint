package cs338.gui.subwindows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorChooserWindowView extends JFrame {

    private static final long serialVersionUID = 1L;
    private Color oldColor;
    private JButton close;
    public JColorChooser me;

    public ColorChooserWindowView(Color currColor) {
        super();
        this.oldColor = currColor;
        this.setLayout(new BorderLayout());
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void initComponents() {
        JPanel options = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        close = new JButton("Close");
        me = new JColorChooser(oldColor);
        options.add(close);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        this.add(me, BorderLayout.CENTER);
        this.add(options, BorderLayout.SOUTH);
    }
}