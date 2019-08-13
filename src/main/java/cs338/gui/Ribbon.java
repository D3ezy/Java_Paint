package cs338.gui;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ribbon extends JPanel {

    JPanel  ribbon_brushes, ribbon_clipboard, ribbon_inner_clipboard, 
            ribbon_image, ribbon_inner_image, ribbon_tools, ribbon_inner_tools,
            ribbon_shapes, ribbon_inner_shapes, ribbon_size, ribbon_colors;

    JButton paste, cut, copy, pencil, paintcan, font, eraser, dropper, 
            magnify, select, crop, resize, rotate, brushes, shapes, 
            shapeoutline, shapefill, pencilsize;
    
    Ribbon() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        initComponents();
    }

    public void initComponents() {
        // instantiate panels & layouts
        // Panels
        ribbon_brushes = new JPanel();
        ribbon_clipboard = new JPanel();
        ribbon_inner_clipboard = new JPanel();
        ribbon_image = new JPanel();
        ribbon_inner_image = new JPanel();
        ribbon_tools = new JPanel();
        ribbon_inner_tools = new JPanel();
        ribbon_shapes = new JPanel();
        ribbon_inner_shapes = new JPanel();
        ribbon_size = new JPanel();
        ribbon_colors = new JPanel();

        // Layouts
        BorderLayout clipboard_layout = new BorderLayout();
        BorderLayout tools_layout = new BorderLayout();
        BoxLayout inner_clipboard_layout = new BoxLayout(ribbon_inner_clipboard, BoxLayout.Y_AXIS);
        GridLayout inner_tools_layout = new GridLayout(2,3);
        BoxLayout inner_image_layout = new BoxLayout(ribbon_inner_image, BoxLayout.Y_AXIS);
        BoxLayout inner_shapes_layout = new BoxLayout(ribbon_inner_shapes, BoxLayout.Y_AXIS);
        BorderLayout image_layout = new BorderLayout();
        BorderLayout shapes_layout = new BorderLayout();
        BorderLayout brushes_layout = new BorderLayout();
        BorderLayout size_layout = new BorderLayout();
        BorderLayout color_layout = new BorderLayout();
        ribbon_clipboard.setLayout(clipboard_layout);
        ribbon_inner_clipboard.setLayout(inner_clipboard_layout);
        ribbon_tools.setLayout(tools_layout);
        ribbon_inner_tools.setLayout(inner_tools_layout);
        ribbon_inner_image.setLayout(inner_image_layout);
        ribbon_inner_shapes.setLayout(inner_shapes_layout);
        ribbon_shapes.setLayout(shapes_layout);
        ribbon_image.setLayout(image_layout);
        ribbon_brushes.setLayout(brushes_layout);
        ribbon_size.setLayout(size_layout);
        ribbon_colors.setLayout(color_layout);

        // Component Instantiation
        // Labels
        JLabel clipboardLabel = new JLabel("Clipboard", SwingConstants.CENTER);
        JLabel toolsLabel = new JLabel("Tools", SwingConstants.CENTER);
        JLabel shapesLabel = new JLabel("Shapes", SwingConstants.CENTER);
        JLabel imageLabel = new JLabel("Image", SwingConstants.CENTER);
        JLabel colorsLabel = new JLabel("Colors", SwingConstants.CENTER);

        // Separators
        JSeparator rib_sep1 = new JSeparator(SwingConstants.VERTICAL);
        JSeparator rib_sep2 = new JSeparator(SwingConstants.VERTICAL);
        JSeparator rib_sep3 = new JSeparator(SwingConstants.VERTICAL);
        JSeparator rib_sep4 = new JSeparator(SwingConstants.VERTICAL);
        JSeparator rib_sep5 = new JSeparator(SwingConstants.VERTICAL);
        JSeparator rib_sep6 = new JSeparator(SwingConstants.VERTICAL);
        JSeparator rib_sep7 = new JSeparator(SwingConstants.VERTICAL);

        // Clipboard
        paste = new JButton("Paste");
        cut = new JButton("Cut");
        copy = new JButton("Copy");

        // Shapes
        shapes = new JButton("Shapes");
        shapeoutline = new JButton("Outline");
        shapefill = new JButton("Fill");
        
        // Image
        select = new JButton("Select");
        crop = new JButton("Crop");
        resize = new JButton("Resize");
        rotate = new JButton("Rotate");

        // Tools
        pencil = new JButton("P");
        eraser = new JButton("E");
        font = new JButton("F");
        magnify = new JButton("M");
        dropper = new JButton("D");
        paintcan = new JButton("C");

        // Brushes
        brushes = new JButton("Brushes");
        brushes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BrushSizeWindow bsw = new BrushSizeWindow();
                bsw.setVisible(true);
            }
        });

        // Brush Size
        pencilsize = new JButton("Size");

        //  Color Pallette
        JButton openChooser = new JButton("Open Color Chooser");
        JColorChooser pallette = new JColorChooser(Color.BLACK);
        pallette.setPreviewPanel(new JPanel());
        JButton currColor1 = new JButton(pallette.getName());

        // Add Buttons & Panels 
        // Clipboard
        ribbon_inner_clipboard.add(cut);
        ribbon_inner_clipboard.add(copy);

        ribbon_clipboard.add(paste, BorderLayout.CENTER);
        ribbon_clipboard.add(ribbon_inner_clipboard, BorderLayout.EAST);
        ribbon_clipboard.add(clipboardLabel, BorderLayout.SOUTH);

        // Image
        ribbon_inner_image.add(crop);
        ribbon_inner_image.add(resize);
        ribbon_inner_image.add(rotate);

        ribbon_image.add(select, BorderLayout.CENTER);
        ribbon_image.add(ribbon_inner_image, BorderLayout.EAST);
        ribbon_image.add(imageLabel, BorderLayout.SOUTH);

        // Tools
        ribbon_inner_tools.add(pencil);
        ribbon_inner_tools.add(magnify);
        ribbon_inner_tools.add(eraser);
        ribbon_inner_tools.add(font);
        ribbon_inner_tools.add(dropper);
        ribbon_inner_tools.add(paintcan);

        ribbon_tools.add(ribbon_inner_tools, BorderLayout.NORTH);
        ribbon_tools.add(toolsLabel, BorderLayout.SOUTH);

        // Brushes
        ribbon_brushes.add(brushes, BorderLayout.CENTER);

        // Shapes
        ribbon_inner_shapes.add(shapeoutline);
        ribbon_inner_shapes.add(shapefill);

        ribbon_shapes.add(shapes, BorderLayout.CENTER);
        ribbon_shapes.add(ribbon_inner_shapes, BorderLayout.EAST);
        ribbon_shapes.add(shapesLabel, BorderLayout.SOUTH);

        // Size
        ribbon_size.add(pencilsize, BorderLayout.CENTER);

        // Color
        ribbon_colors.add(currColor1, BorderLayout.WEST);
        ribbon_colors.add(colorsLabel, BorderLayout.SOUTH);
        ribbon_colors.add(openChooser, BorderLayout.CENTER);

        // Main Ribbon
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(ribbon_clipboard);                             // Clipboard
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(rib_sep1);                                     // Separator
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(ribbon_image);                                 // Image 
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(rib_sep2);                                     // Separator
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(ribbon_tools);                                 // Tools
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(rib_sep3);                                     // Separator
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(ribbon_brushes);                               // Brush Selector
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(rib_sep4);                                     // Separator
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(ribbon_shapes);                                // Shapes Selector
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(rib_sep5);                                     // Separator
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(ribbon_size);                                  // Pencil Size
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(rib_sep6);                                     // Separator
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(ribbon_colors);                                // Color Panel
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(rib_sep7);                                     // Separator  
        return;
    }

}