package cs338.gui;

import javax.swing.JMenuBar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;
import cs338.gui.subwindows.AboutWindowView;
import cs338.gui.subwindows.PropertiesWindowView;

public class MenuBarView extends JMenuBar implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JMenu filemenu, viewmenu, editmenu;
    private JMenuItem newFile, zoomIn, zoomOut, zoomReset, open, save;
	public JMenuItem saveAs;
	private JMenuItem properties;
	private JMenuItem about;
	private JMenuItem exit;
	private JMenuItem undo;
	private JMenuItem redo;
    private JSeparator separator1;

    MenuBarView() {
        super();
        initComponents();      
        prepareIcons();
    }

    public void initComponents() {
        newFile = new JMenuItem("New...");
        newFile.setToolTipText("Creates a new file");
        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        zoomIn = new JMenuItem("Zoom in");
        zoomIn.setToolTipText("Zooms in on canvas");
        zoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, ActionEvent.CTRL_MASK));
        zoomOut = new JMenuItem("Zoom out");
        zoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, ActionEvent.CTRL_MASK));
        zoomOut.setToolTipText("Zooms out on canvas");
        zoomReset = new JMenuItem("Reset Zoom");
        zoomReset.setToolTipText("Resets the canvas to default zoom");
        zoomReset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, ActionEvent.CTRL_MASK));
        open = new JMenuItem("Open");
        open.setToolTipText("Opens an image from a directory");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        save = new JMenuItem("Save");
        save.setToolTipText("Saves and image to a directory");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveAs = new JMenuItem("Save As");
        saveAs.setEnabled(false);
        properties = new JMenuItem("Properties");
        properties.setToolTipText("Opens the image properties window");
        about = new JMenuItem("About");
        about.setToolTipText("Opens the about Java Paint window");
        exit = new JMenuItem("Exit");
        exit.setToolTipText("Exits the program");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        undo = new JMenuItem("Undo");
        undo.setToolTipText("Removes last edit to canvas");
        undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        redo = new JMenuItem("Redo");
        redo.setToolTipText("Reinstates last edit to canvas");
        redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
        undo.setEnabled(false);
        redo.setEnabled(false);
        filemenu = new JMenu("File");
        viewmenu = new JMenu("View");
        editmenu = new JMenu("Edit");
        separator1 = new JSeparator(SwingConstants.HORIZONTAL);

        newFile.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        properties.addActionListener(this);
        about.addActionListener(this);
        exit.addActionListener(this);
        undo.addActionListener(this);
        redo.addActionListener(this);
        zoomIn.addActionListener(this);
        zoomOut.addActionListener(this);
        zoomReset.addActionListener(this);

        filemenu.add(newFile);
        filemenu.add(open);
        filemenu.add(save);
        filemenu.add(saveAs);
        filemenu.add(separator1);
        filemenu.add(properties);
        filemenu.add(about);
        filemenu.add(exit);
        editmenu.add(undo);
        editmenu.add(redo);
        viewmenu.add(zoomIn);
        viewmenu.add(zoomOut);
        viewmenu.add(zoomReset);
        this.add(filemenu);
        this.add(editmenu);
        this.add(viewmenu);
    }

    private void prepareIcons() {
        FontIcon newFile_icon = FontIcon.of(FontAwesomeSolid.FILE, Color.BLACK);
        FontIcon open_icon = FontIcon.of(FontAwesomeSolid.FOLDER_OPEN, Color.BLACK);
        FontIcon zoomIn_icon = FontIcon.of(FontAwesomeSolid.SEARCH_PLUS, Color.BLACK);
        FontIcon zoomOut_icon = FontIcon.of(FontAwesomeSolid.SEARCH_MINUS, Color.BLACK);
        FontIcon zoomReset_icon = FontIcon.of(FontAwesomeSolid.SEARCH, Color.BLACK);
        FontIcon save_icon = FontIcon.of(FontAwesomeSolid.SAVE, Color.BLACK);
        FontIcon saveAs_icon = FontIcon.of(FontAwesomeSolid.FILE_ALT, Color.BLACK);
        FontIcon properties_icon = FontIcon.of(FontAwesomeSolid.PARAGRAPH, Color.BLACK);
        FontIcon about_icon = FontIcon.of(FontAwesomeSolid.QUESTION_CIRCLE, Color.BLACK);
        FontIcon exit_icon = FontIcon.of(FontAwesomeSolid.ARROW_CIRCLE_LEFT, Color.BLACK);
        FontIcon undo_icon = FontIcon.of(FontAwesomeSolid.UNDO, Color.BLACK);
        FontIcon redo_icon = FontIcon.of(FontAwesomeSolid.REDO, Color.BLACK);

        newFile.setIcon(newFile_icon);
        zoomIn.setIcon(zoomIn_icon);
        zoomOut.setIcon(zoomOut_icon);
        open.setIcon(open_icon);
        save.setIcon(save_icon);
        saveAs.setIcon(saveAs_icon);
        properties.setIcon(properties_icon);
        about.setIcon(about_icon);
        exit.setIcon(exit_icon);
        undo.setIcon(undo_icon);
        redo.setIcon(redo_icon);
        zoomReset.setIcon(zoomReset_icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == about) {
            AboutWindowView awv = new AboutWindowView();
            awv.setVisible(true);
        } else if (e.getSource() == exit) {
            MainFrame.canvas.clear();
            System.exit(0);
        } else if (e.getSource() == properties) {
            PropertiesWindowView pwv = new PropertiesWindowView();
            pwv.setVisible(true);
        } else if (e.getSource() == save) {
            String filename;
            JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG Images", "jpeg", "jpg");
            fc.setFileFilter(filter);
            fc.setCurrentDirectory(new File("./Documents"));
            int retrival = fc.showSaveDialog(null);
            if (retrival == JFileChooser.APPROVE_OPTION) {
                filename = fc.getSelectedFile().toString();
                MainFrame.canvas.saveImage(filename);
            }
        } else if (e.getSource() == open) {
            JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG Images", "jpeg", "jpg");
            fc.setFileFilter(filter);
            fc.setCurrentDirectory(new File("./Documents"));
            int returnVal = fc.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
               System.out.println("You chose to open this file: " +
                    fc.getSelectedFile().getName());
            }
            String name = fc.getCurrentDirectory() + "/" + fc.getSelectedFile().getName();
            System.out.println(name);
            MainFrame.canvas.loadImage(name);
            this.saveAs.setEnabled(true);
        } else if (e.getSource() == undo) {
            MainFrame.canvas.undo();
            redo.setEnabled(true);
        } else if (e.getSource() == redo) {
            MainFrame.canvas.redo();
        } else if (e.getSource() == newFile) {
            MainFrame.canvas.clear();
        } else {
            return;
        }
        return;
    }

    public void enableUndo() {
        this.undo.setEnabled(true);
    }

    public void enableRedo() {
        this.redo.setEnabled(true);
    }
}