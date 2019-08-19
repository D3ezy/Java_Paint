package cs338.gui.subwindows;

import java.awt.Color;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import cs338.gui.MainFrame;

public class FileNotSavedDialogView extends JOptionPane {

    private static final long serialVersionUID = 1L;
    final String saveDialog = "This drawing has not been saved, would you like to save it?";
    Object[] options = { "Save", "Don't Save", "Cancel" };
    int result;

    public FileNotSavedDialogView() {
        prepareIcons();
        this.result = showConfirmDialog(this, "Do you want to save changes?");
    }

    public int handle() {
        if (result == JOptionPane.CANCEL_OPTION) {
            return 1;
        } else if (result == JOptionPane.CLOSED_OPTION) {
            return 1;
        } else if (result == JOptionPane.YES_OPTION) {
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
            return 0;
        } else if (result == JOptionPane.NO_OPTION) {
            MainFrame.canvas.setHasBeenDrawn(false);
            MainFrame.canvas.clear();
            return 0;
        }
        return 1;
    }

    public void prepareIcons() {
        FontIcon saveIcon = FontIcon.of(FontAwesomeSolid.SAVE, Color.RED);
        this.setIcon(saveIcon);
    }

}