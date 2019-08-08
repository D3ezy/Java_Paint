package cs338.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class MainFrame extends JFrame {

    JMenuBar menubar;
    JMenu filemenu;
    JMenuItem item; 
    
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
        item = new JMenuItem("New...");
        filemenu.add(item);
        menubar.add(filemenu);

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
        this.setPreferredSize(new Dimension(800,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }
}
