package cs338.gui;

import cs338.gui.ribbon.RibbonView;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    JMenuBar menubar;
    JMenu filemenu, viewmenu;
    JMenuItem newFile, zoomIn, zoomOut; 
    
    public MainFrame() {
        initComponents();
        this.setTitle("Java Paint v0.9");
        this.setPreferredSize(new Dimension(1500,900));
        this.setMinimumSize(new Dimension(1000,850));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

        // Frame layout
        this.setLayout(new BorderLayout(5,5));

        // ---- Menu Bar ------------------- //
        menubar = new MenuBarView();

        // ---- Ribbon ---------------------- //
        RibbonView ribbon = new RibbonView();
        JPanel ribbonContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ribbonContainer.add(ribbon);
        ribbonContainer.setBorder(BorderFactory.createCompoundBorder(new EtchedBorder(EtchedBorder.RAISED), new EmptyBorder(5,5,5,5)));

        // ---- Canvas ---------------------- //
        PaintCanvasView canvas = new PaintCanvasView();
        JPanel canvasContainer = new JPanel(new GridBagLayout());
        canvasContainer.setBackground(Color.GRAY);
        canvasContainer.add(canvas);

        // ---- Bottom Info Bar ------------- //
        InfoBarView info_bar = new InfoBarView();

        // ---- Add Panels------------------- //
        this.setJMenuBar(menubar);
        this.add(ribbonContainer, BorderLayout.NORTH);
        this.add(canvasContainer, BorderLayout.CENTER);
        this.add(info_bar, BorderLayout.SOUTH);
    }
}
