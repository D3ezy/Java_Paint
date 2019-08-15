package cs338.gui;

import javax.swing.JMenuBar;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

public class MenuBarView extends JMenuBar {

    private static final long serialVersionUID = 1L;
    private JMenu filemenu, viewmenu;
    private JMenuItem newFile, zoomIn, zoomOut, open, save, saveAs, properties, about, exit;
    private JSeparator separator1;

    MenuBarView() {
        super();
        initComponents();
        prepareIcons();
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

    private void prepareIcons() {
        FontIcon newFile_icon = FontIcon.of(FontAwesomeSolid.FILE, Color.BLACK);
        FontIcon open_icon = FontIcon.of(FontAwesomeSolid.FOLDER_OPEN, Color.BLACK);
        FontIcon zoomIn_icon = FontIcon.of(FontAwesomeSolid.SEARCH_PLUS, Color.BLACK);
        FontIcon zoomOut_icon = FontIcon.of(FontAwesomeSolid.SEARCH_MINUS, Color.BLACK);
        FontIcon save_icon = FontIcon.of(FontAwesomeSolid.SAVE, Color.BLACK);
        FontIcon saveAs_icon = FontIcon.of(FontAwesomeSolid.FILE_ALT, Color.BLACK);
        FontIcon properties_icon = FontIcon.of(FontAwesomeSolid.PARAGRAPH, Color.BLACK);
        FontIcon about_icon = FontIcon.of(FontAwesomeSolid.QUESTION_CIRCLE, Color.BLACK);
        FontIcon exit_icon = FontIcon.of(FontAwesomeSolid.ARROW_CIRCLE_LEFT, Color.BLACK);

        newFile.setIcon(newFile_icon);
        zoomIn.setIcon(zoomIn_icon);
        zoomOut.setIcon(zoomOut_icon);
        open.setIcon(open_icon);
        save.setIcon(save_icon);
        saveAs.setIcon(saveAs_icon);
        properties.setIcon(properties_icon);
        about.setIcon(about_icon);
        exit.setIcon(exit_icon);
    }
}