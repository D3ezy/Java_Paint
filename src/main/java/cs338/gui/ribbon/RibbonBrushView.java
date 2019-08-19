package cs338.gui.ribbon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import cs338.gui.MainFrame;
import cs338.gui.canvas.Brush;
import cs338.gui.canvas.PaintBrush;
import cs338.gui.canvas.PencilBrush;
import cs338.gui.subwindows.BrushSizeWindowView;

public class RibbonBrushView extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    JRadioButton thin, medthin, med, medthick, thick;
    JRadioButton pencil, paintbrush;
    JButton brushOptions;
    JComboBox<String> brushThickness;
    JComboBox<String> pencilType;
    String[] thicknesses = {"Thin", "Medium Thin", "Medium", "Medium Thick", "Thick"};
    String[] pencils = {"Pencil", "Paintbrush"};
    int newBrushSize;
    Brush newBrush;

    RibbonBrushView() {
        super();
        this.setLayout(new BorderLayout(5,5));
        initComponents();
        prepareIcons();
        this.newBrush = new PencilBrush(10);
        this.newBrushSize = this.newBrush.getBrushX();
    }

    public void initComponents() {

        JPanel inner_brushes = new JPanel(new BorderLayout());
        brushThickness = new JComboBox<>(thicknesses);
        brushThickness.setToolTipText("Changes the thickness of the current brush");
        pencilType = new JComboBox<>(pencils);
        pencilType.setToolTipText("Changes the type of brush being used");
        brushThickness.setPreferredSize(new Dimension(100,30));
        pencilType.setPreferredSize(new Dimension(100,30));

        // init labels
        JLabel brushes_label = new JLabel("Brush", SwingConstants.CENTER);

        // component instantiation
        brushOptions = new JButton("Brush Options");
        brushOptions.setToolTipText("Opens Brush Options Window");
        brushOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BrushSizeWindowView bsw = new BrushSizeWindowView();
                bsw.setVisible(true);
            }
        });
        brushThickness.addActionListener(this);
        pencilType.addActionListener(this);

        inner_brushes.add(brushThickness, BorderLayout.NORTH);
        inner_brushes.add(pencilType, BorderLayout.SOUTH);

        // add components
        this.add(inner_brushes, BorderLayout.NORTH);
        this.add(brushOptions, BorderLayout.CENTER);
        this.add(brushes_label, BorderLayout.SOUTH);
        
    }

    public void prepareIcons() {
        FontIcon brush_icon = FontIcon.of(FontAwesomeSolid.PAINT_BRUSH, Color.BLACK);
        brushOptions.setIcon(brush_icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == brushThickness) {
            String selection = (String) brushThickness.getSelectedItem();
            if (selection.equals("Thin")) {
                newBrushSize = 5;
                newBrush.changeBrushSize(this.newBrushSize); // you don't want to change the size of the current brush, because it will repaint everything else
                MainFrame.canvas.changeBrush(newBrush);
            } else if (selection.equals("Medioum Thin")) {
                newBrushSize = 10;
                newBrush.changeBrushSize(this.newBrushSize); // you don't want to change the size of the current brush, because it will repaint everything else
                MainFrame.canvas.changeBrush(newBrush);
            } else if (selection.equals("Medium")) {
                newBrushSize = 20;
                newBrush.changeBrushSize(this.newBrushSize); // you don't want to change the size of the current brush, because it will repaint everything else
                MainFrame.canvas.changeBrush(newBrush);
            } else if (selection.equals("Medium Thick")) {
                newBrushSize = 30;
                newBrush.changeBrushSize(this.newBrushSize); // you don't want to change the size of the current brush, because it will repaint everything else
                MainFrame.canvas.changeBrush(newBrush);
            } else if (selection.equals("Thick")) {
                newBrushSize = 40;
                newBrush.changeBrushSize(this.newBrushSize); // you don't want to change the size of the current brush, because it will repaint everything else
                MainFrame.canvas.changeBrush(newBrush);
            }
        } else if (e.getSource() == pencilType) {
            String selection = (String) pencilType.getSelectedItem();
            if (selection.equals("Pencil")) {
                this.newBrush = new PencilBrush(this.newBrushSize);
                MainFrame.canvas.changeBrush(newBrush);
            } else if (selection.equals("Paintbrush")) {
                this.newBrush = new PaintBrush(this.newBrushSize);
                MainFrame.canvas.changeBrush(newBrush);
            }
        }
    }
}