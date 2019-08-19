package cs338.gui.ribbon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import cs338.gui.MainFrame;
import cs338.gui.subwindows.ResizeWindowView;

public class RibbonImageView extends JPanel implements ActionListener{

    private static final long serialVersionUID = 1L;
    JPanel inner_image;
    JButton clear, save, rotate, resize, newFile, openFile;

    RibbonImageView() {
        super();
        this.setLayout(new BorderLayout());
        initComponents();
        prepareIcons();
    }

    public void initComponents() {
        // init inner panel
        inner_image = new JPanel();
        inner_image.setLayout(new BoxLayout(inner_image, BoxLayout.Y_AXIS));

        // init label
        JLabel imageLabel = new JLabel("Image", SwingConstants.CENTER);

        // init buttons
        clear = new JButton("Clear");
        this.clear.setEnabled(true);
        save = new JButton("Save");
        resize = new JButton("Resize");
        rotate = new JButton("Rotate");
        newFile = new JButton("New...");
        openFile = new JButton("Open");
        save.setToolTipText("Save canvas to file");
        openFile.setToolTipText("Open canvas from file");
        newFile.setToolTipText("Create a new blank canvas");
        resize.setToolTipText("Change size of canvas (NOT WORKING)");
        rotate.setToolTipText("Rotate canvas (NOT WORKING)");
        clear.setToolTipText("Clear canvas of all drawings");

        clear.addActionListener(this);
        save.addActionListener(this);
        resize.addActionListener(this);
        rotate.addActionListener(this);
        newFile.addActionListener(this);
        openFile.addActionListener(this);

        // add components
        inner_image.add(newFile);
        inner_image.add(openFile);
        inner_image.add(save);
        inner_image.add(resize);
        inner_image.add(rotate);

        this.add(clear, BorderLayout.CENTER);
        this.add(inner_image, BorderLayout.EAST);
        this.add(imageLabel, BorderLayout.SOUTH);
        
    }

    private void prepareIcons() {
        FontIcon clear_icon = FontIcon.of(FontAwesomeSolid.OBJECT_UNGROUP, Color.BLACK);
        FontIcon save_icon = FontIcon.of(FontAwesomeSolid.SAVE, Color.BLACK);
        FontIcon resize_icon = FontIcon.of(FontAwesomeSolid.CLONE, Color.BLACK);
        FontIcon rotate_icon = FontIcon.of(FontAwesomeSolid.RETWEET, Color.BLACK);
        FontIcon new_icon = FontIcon.of(FontAwesomeSolid.FILE, Color.BLACK);
        FontIcon open_icon = FontIcon.of(FontAwesomeSolid.FILE_IMAGE, Color.BLACK);
        clear.setIcon(clear_icon);
        save.setIcon(save_icon);
        resize.setIcon(resize_icon);
        rotate.setIcon(rotate_icon);
        this.newFile.setIcon(new_icon);
        this.openFile.setIcon(open_icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newFile) {
            MainFrame.canvas.clear();
        } else if (e.getSource() == openFile) {
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
            MainFrame.menubar.saveAs.setEnabled(true);
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
        } else if (e.getSource() == resize) {
            ResizeWindowView rwv = new ResizeWindowView();
            rwv.setVisible(true);
        } else if (e.getSource() == rotate) {
            MainFrame.canvas.rotate();
        } else if (e.getSource() == clear) {
            MainFrame.canvas.clear();
        }
	}

}