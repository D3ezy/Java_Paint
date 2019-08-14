package cs338.gui;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class MenuBarView extends JMenuBar {

    private JMenu filemenu, viewmenu;
    private JMenuItem newFile, zoomIn, zoomOut, open, save, saveAs, properties, about, exit;
    private JSeparator separator1;

    MenuBarView() {
        initComponents();
    }

    public void initComponents() {
        filemenu = new JMenu("File");
        viewmenu = new JMenu("View");
        newFile = new JMenuItem("New...");
        zoomIn = new JMenuItem("Zoom in");
        zoomOut = new JMenuItem("Zoom out");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        saveAs = new JMenuItem("Save As");
        properties = new JMenuItem("Properties");
        about = new JMenuItem("About");
        exit = new JMenuItem("Exit");

        separator1 = new JSeparator(SwingConstants.HORIZONTAL);

        filemenu.add(newFile);
        filemenu.add(open);
        filemenu.add(save);
        filemenu.add(saveAs);
        filemenu.add(separator1);
        filemenu.add(properties);
        filemenu.add(about);
        filemenu.add(exit);
        viewmenu.add(zoomIn);
        viewmenu.add(zoomOut);
        this.add(filemenu);
        this.add(viewmenu);
    }
}