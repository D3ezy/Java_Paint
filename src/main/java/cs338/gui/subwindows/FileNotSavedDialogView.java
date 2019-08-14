package cs338.gui.subwindows;

import javax.swing.JOptionPane;

public class FileNotSavedDialogView extends JOptionPane {

    final String saveDialog = "This drawing has not been saved, would you like to save it?";
    Object[] options = { "Save", "Don't Save", "Cancel" };

    FileNotSavedDialogView(){}

    /*@Override
    static int showOptionDialog(Component parentComponent, Object message, String title, int optionType, int messageType, Icon icon, Object[] options, Object initialValue) {
        this.showOptionDialog(null, saveDialog, "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
    }*/

}