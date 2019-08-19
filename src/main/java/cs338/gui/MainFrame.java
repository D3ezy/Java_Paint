package cs338.gui;

import cs338.gui.canvas.PaintCanvasView;
import cs338.gui.ribbon.RibbonView;
import javax.swing.JMenu;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class MainFrame extends JFrame implements WindowListener {

    private static final long serialVersionUID = 1L;
    JMenu filemenu, viewmenu;
    JMenuItem newFile, zoomIn, zoomOut;
    public static PaintCanvasView canvas;
    public static InfoBarView info_bar;
    public static MenuBarView menubar;
    public static RibbonView ribbon;
    
    public MainFrame() {
        initComponents();
        this.setTitle("Java Paint v0.9");
        this.setPreferredSize(new Dimension(1400,900));
        this.setMinimumSize(new Dimension(1260,850));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addWindowListener(this);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

        // Frame layout
        this.setLayout(new BorderLayout(5,5));

        // ---- Menu Bar ------------------- //
        menubar = new MenuBarView();

        // ---- Ribbon ---------------------- //
        ribbon = new RibbonView();
        JPanel ribbonContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ribbonContainer.add(ribbon);
        ribbonContainer.setBorder(BorderFactory.createCompoundBorder(new EtchedBorder(EtchedBorder.RAISED), new EmptyBorder(5,5,5,5)));

        // ---- Canvas ---------------------- //
        canvas = new PaintCanvasView();
        JPanel parentContainer = new JPanel();
        JPanel canvasContainer = new JPanel(new GridBagLayout());
        JScrollPane sp = new JScrollPane(parentContainer, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        canvasContainer.add(canvas);
        parentContainer.add(canvasContainer);
        parentContainer.setBackground(Color.GRAY);

        // ---- Bottom Info Bar ------------- //
        info_bar = new InfoBarView();

        // ---- Add Panels------------------- //
        this.setJMenuBar(menubar);
        this.add(ribbonContainer, BorderLayout.NORTH);
        this.add(sp, BorderLayout.CENTER);
        this.add(info_bar, BorderLayout.SOUTH);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        canvas.clear();
    }

    @Override
    public void windowOpened(WindowEvent e) {}
    @Override
    public void windowClosed(WindowEvent e) {}
    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
