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
import cs338.gui.MainFrame;
import cs338.gui.canvas.Brush;
import cs338.gui.canvas.PaintBrush;
import cs338.gui.canvas.PencilBrush;

public class BrushSizeWindowView extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel brushSizePanel, brushTypePanel, optionsPanel;
    private JButton ok, cancel;
    private JRadioButton thin, medthin, med, medthick, thick;
    private JRadioButton pencil, paintbrush;
    private int newBrushSize;
    private Brush newBrush;

    public BrushSizeWindowView() {
        super();
        this.setLayout(new BorderLayout(10,10));
        initComponents();
        this.newBrush = MainFrame.canvas.getCurrentBrush();
        this.newBrushSize = this.newBrush.getBrushX();
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

        // radio buttons
        thin = new JRadioButton("thin");
        medthin = new JRadioButton("medthin");
        med = new JRadioButton("med");
        med.setSelected(true);
        medthick = new JRadioButton("medthick");
        thick = new JRadioButton("thick");
        pencil = new JRadioButton("pencil");
        pencil.setSelected(true);
        paintbrush = new JRadioButton("paintbrush");

        ok.addActionListener(this);
        cancel.addActionListener(this);
        thin.addActionListener(this);
        medthin.addActionListener(this);
        med.addActionListener(this);
        medthick.addActionListener(this);
        thick.addActionListener(this);
        pencil.addActionListener(this);
        paintbrush.addActionListener(this);
    
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == thin) {
            thin.setSelected(true);
            medthin.setSelected(false);
            med.setSelected(false);
            medthick.setSelected(false);
            thick.setSelected(false);
            newBrushSize = 5;
        } else if (e.getSource() == medthin) {
            thin.setSelected(false);
            medthin.setSelected(true);
            med.setSelected(false);
            medthick.setSelected(false);
            thick.setSelected(false);
            newBrushSize = 10;
        } else if (e.getSource() == med) {
            thin.setSelected(false);
            medthin.setSelected(false);
            med.setSelected(true);
            medthick.setSelected(false);
            thick.setSelected(false);
            newBrushSize = 20;
        } else if (e.getSource() == medthick) {
            thin.setSelected(false);
            medthin.setSelected(false);
            med.setSelected(false);
            medthick.setSelected(true);
            thick.setSelected(false);
            newBrushSize = 30;
        } else if (e.getSource() == thick) {
            thin.setSelected(false);
            medthin.setSelected(false);
            med.setSelected(false);
            medthick.setSelected(false);
            thick.setSelected(true);
            newBrushSize = 40;
        } else if (e.getSource() == pencil) {
            pencil.setSelected(true);
            paintbrush.setSelected(false);
            this.newBrush = new PencilBrush(this.newBrushSize);
        } else if (e.getSource() == paintbrush) {
            pencil.setSelected(false);
            paintbrush.setSelected(true);
            this.newBrush = new PaintBrush(this.newBrushSize);
        } else if (e.getSource() == ok) {
            newBrush.changeBrushSize(this.newBrushSize); // you don't want to change the size of the current brush, because it will repaint everything else
            MainFrame.canvas.changeBrush(newBrush);
            dispose();
        } else if (e.getSource() == cancel) {
            dispose();
        }
    }
}