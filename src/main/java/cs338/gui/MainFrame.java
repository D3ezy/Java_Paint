package cs338.gui;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class MainFrame extends JFrame {

    JPanel canvas, ribbon, ribbon_clipboard, ribbon_inner_clipboard, ribbon_image, ribbon_color_chooser, 
            ribbon_tools, ribbon_inner_tools, ribbon_shapes, ribbon_size, ribbon_colors, bottom_info_bar,
            ribbon_inner_image, ribbon_inner_shapes, ribbon_brushes;
    JButton paste, cut, copy, pencil, paintcan, font, eraser, dropper, magnify, select, crop, resize, rotate, brushes,
            shapes, shapeoutline, shapefill, pencilsize;
    JMenuBar menubar;
    JMenu filemenu;
    JMenuItem item;
    
    
    public MainFrame() {
        initComponents();
    }

    private void initComponents() {
        // Frame layout
        this.setLayout(new BorderLayout());

        // Menu Bar
        menubar = new JMenuBar();
        filemenu = new JMenu("File");
        item = new JMenuItem("New...");
        filemenu.add(item);
        menubar.add(filemenu);

        // ---------------------------------------------------------------
        // ---- Ribbon
        // ---------------------------------------------------------------

        // instantiate panels & layouts
        // Panels
        ribbon = new JPanel();
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
        BoxLayout ribbon_layout = new BoxLayout(ribbon, BoxLayout.X_AXIS);
        BorderLayout clipboard_layout = new BorderLayout();
        BorderLayout tools_layout = new BorderLayout();
        BoxLayout inner_clipboard_layout = new BoxLayout(ribbon_inner_clipboard, BoxLayout.Y_AXIS);
        GridLayout inner_tools_layout = new GridLayout(2,3);
        BoxLayout inner_image_layout = new BoxLayout(ribbon_inner_image, BoxLayout.Y_AXIS);
        BoxLayout inner_shapes_layout = new BoxLayout(ribbon_inner_shapes, BoxLayout.Y_AXIS);
        BorderLayout image_layout = new BorderLayout();
        BorderLayout shapes_layout = new BorderLayout();
        BorderLayout brushes_layout = new BorderLayout();
        ribbon.setLayout(ribbon_layout);
        ribbon_clipboard.setLayout(clipboard_layout);
        ribbon_inner_clipboard.setLayout(inner_clipboard_layout);
        ribbon_tools.setLayout(tools_layout);
        ribbon_inner_tools.setLayout(inner_tools_layout);
        ribbon_inner_image.setLayout(inner_image_layout);
        ribbon_inner_shapes.setLayout(inner_shapes_layout);
        ribbon_shapes.setLayout(shapes_layout);
        ribbon_image.setLayout(image_layout);
        ribbon_brushes.setLayout(brushes_layout);

        // Component Instantiation
        // Labels
        JLabel clipboardLabel = new JLabel("Clipboard", SwingConstants.CENTER);
        JLabel toolsLabel = new JLabel("Tools", SwingConstants.CENTER);
        JLabel shapesLabel = new JLabel("Shapes", SwingConstants.CENTER);
        JLabel imageLabel = new JLabel("Image", SwingConstants.CENTER);

        // Separators
        JSeparator rib_sep1 = new JSeparator(SwingConstants.VERTICAL);
        JSeparator rib_sep2 = new JSeparator(SwingConstants.VERTICAL);
        JSeparator rib_sep3 = new JSeparator(SwingConstants.VERTICAL);
        JSeparator rib_sep4 = new JSeparator(SwingConstants.VERTICAL);
        JSeparator rib_sep5 = new JSeparator(SwingConstants.VERTICAL);

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

        // Add Buttons & Panels 
        // Clipboard
        ribbon_inner_clipboard.add(cut);
        ribbon_inner_clipboard.add(copy);

        ribbon_clipboard.add(paste, BorderLayout.CENTER);
        ribbon_clipboard.add(ribbon_inner_clipboard, BorderLayout.EAST);
        ribbon_clipboard.add(clipboardLabel, BorderLayout.SOUTH);

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

        // Image
        ribbon_inner_image.add(crop);
        ribbon_inner_image.add(resize);
        ribbon_inner_image.add(rotate);

        ribbon_image.add(select, BorderLayout.CENTER);
        ribbon_image.add(ribbon_inner_image, BorderLayout.EAST);
        ribbon_image.add(imageLabel, BorderLayout.SOUTH);

        // Main Ribbon
        ribbon.add(Box.createRigidArea(new Dimension(5,0)));
        ribbon.add(ribbon_clipboard);
        ribbon.add(Box.createRigidArea(new Dimension(5,0)));
        ribbon.add(rib_sep1);
        ribbon.add(Box.createRigidArea(new Dimension(5,0)));
        ribbon.add(ribbon_image);
        ribbon.add(Box.createRigidArea(new Dimension(5,0)));
        ribbon.add(rib_sep2);
        ribbon.add(Box.createRigidArea(new Dimension(5,0)));
        ribbon.add(ribbon_tools);
        ribbon.add(Box.createRigidArea(new Dimension(5,0)));
        ribbon.add(rib_sep3);
        ribbon.add(Box.createRigidArea(new Dimension(5,0)));
        ribbon.add(ribbon_brushes);
        ribbon.add(Box.createRigidArea(new Dimension(5,0)));
        ribbon.add(rib_sep4);
        ribbon.add(Box.createRigidArea(new Dimension(5,0)));
        ribbon.add(ribbon_shapes);
        ribbon.add(Box.createRigidArea(new Dimension(5,0)));
        ribbon.add(rib_sep5);
        ribbon.add(Box.createRigidArea(new Dimension(5,0)));

        // ----------------------------------------------------------------
        // ---- Canvas
        // ----------------------------------------------------------------

        // ----------------------------------------------------------------
        // ---- Bottom Info Bar
        // ----------------------------------------------------------------

        // ----------------------------------------------------------------
        // ---- Add Panels
        // ----------------------------------------------------------------

        this.setJMenuBar(menubar);
        this.add(ribbon, BorderLayout.NORTH);
        this.setPreferredSize(new Dimension(400,300));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }
}
