package cs338.gui.subwindows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class BrushSizeWindowView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel brushSizePanel, brushTypePanel, optionsPanel;
    private JButton ok, cancel;
    private JRadioButton thin, medthin, med, medthick, thick;
    private JRadioButton pencil, paintbrush;

    public BrushSizeWindowView() {
        super();
        this.setLayout(new BorderLayout(10,10));
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Brush Settings");
        this.setPreferredSize(new Dimension(400,330));
        this.setMinimumSize(new Dimension(400,330));
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void initComponents() {

        // init panels
        brushSizePanel = new JPanel();
        brushSizePanel.setLayout(new BoxLayout(brushSizePanel, BoxLayout.Y_AXIS));
        brushTypePanel = new JPanel();
        brushTypePanel.setLayout(new BoxLayout(brushTypePanel, BoxLayout.Y_AXIS));
        optionsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        brushSizePanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5,5,0,5), new TitledBorder("Brush Size")));
        brushTypePanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0,5,5,5), new TitledBorder("Brush Type")));

        // initialize buttons

        // ok/cancel buttons
        ok = new JButton("OK");
        cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // radio buttons
        thin = new JRadioButton("thin");
        medthin = new JRadioButton("medthin");
        med = new JRadioButton("med");
        medthick = new JRadioButton("medthick");
        thick = new JRadioButton("thick");
        pencil = new JRadioButton("pencil");
        paintbrush = new JRadioButton("paintbrush");

        // add panels
        optionsPanel.add(ok);
        optionsPanel.add(cancel);
        brushSizePanel.add(thin);
        brushSizePanel.add(medthin);
        brushSizePanel.add(med);
        brushSizePanel.add(medthick);
        brushSizePanel.add(thick);
        brushTypePanel.add(pencil);
        brushTypePanel.add(paintbrush);
        this.add(brushSizePanel, BorderLayout.NORTH);
        this.add(brushTypePanel, BorderLayout.CENTER);
        this.add(optionsPanel, BorderLayout.SOUTH);
    }
}