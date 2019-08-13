package cs338.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class MainFrame extends JFrame {

    JMenuBar menubar;
    JMenu filemenu, viewmenu;
    JMenuItem newFile, zoomIn, zoomOut; 
    
    public MainFrame() {
        initComponents();
    }

    private void initComponents() {

        // Frame layout
        this.setLayout(new BorderLayout(5,5));

        // --------------------------------- //
        // ---- Menu Bar ------------------- //
        // --------------------------------- //
        menubar = new JMenuBar();
        filemenu = new JMenu("File");
        viewmenu = new JMenu("View");
        newFile = new JMenuItem("New...");
        zoomIn = new JMenuItem("Zoom in");
        zoomOut = new JMenuItem("Zoom out");

        filemenu.add(newFile);
        viewmenu.add(zoomIn);
        viewmenu.add(zoomOut);
        menubar.add(filemenu);
        menubar.add(viewmenu);

        // ---- Ribbon ---------------------- //
        Ribbon ribbon = new Ribbon();
        JPanel ribbonContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ribbonContainer.add(ribbon);

        // ---- Canvas ---------------------- //
        PaintCanvas canvas = new PaintCanvas();
        JPanel canvasContainer = new JPanel(new BorderLayout(10,10));
        canvasContainer.add(canvas, BorderLayout.NORTH);

        // ---- Bottom Info Bar ------------- //
        InfoBar info_bar = new InfoBar();

        // ---------------------------------- //
        // ---- Add Panels------------------- //
        // ---------------------------------- //

        this.setJMenuBar(menubar);
        this.add(ribbonContainer, BorderLayout.NORTH);
        this.add(canvasContainer, BorderLayout.WEST);
        this.add(info_bar, BorderLayout.SOUTH);
        this.setTitle("Java Paint v0.9");
        this.setPreferredSize(new Dimension(800,1000));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }
}
