package cs338.gui.canvas;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FontChooserView extends JOptionPane {

    private static final long serialVersionUID = 1L;

    JPanel boxLayout;
    JTextField stringToPaint;
    JComboBox<String> availableFonts;
    JComboBox<String> fontSizes;
    JLabel font, size, string;
    String selectedFont, selectedText, selectedSize;
    String[] items = {"Times New Roman", "Helvetica"};
    String[] sizes = {"10","11","12","20", "22", "26", "30", "32", "36","40","45", "50"};

    public FontChooserView() {
        super();
        initComponents();
        int result;
        handle(result = showOptionDialog(this,this.boxLayout,"Text Box Settings", OK_CANCEL_OPTION, 0, null, null, 0));
    }

    public void initComponents() {
        boxLayout = new JPanel();
        stringToPaint = new JTextField();
        availableFonts = new JComboBox<>(items);
        fontSizes = new JComboBox<>(sizes);
        boxLayout.add(availableFonts);
        boxLayout.add(fontSizes);
        boxLayout.add(stringToPaint);
        this.add(boxLayout);
        stringToPaint.setPreferredSize(new Dimension(100,20));
    } 

    public String getText() {
        return this.selectedText;
    }

    public Font getFontType() {
        return new Font(this.selectedFont, Font.PLAIN, Integer.parseInt(this.selectedSize));
    }

    public int handle(int result) {
        if (result == OK_OPTION) {
            System.out.print("THIS IS THE TEXT ENTERED: " + stringToPaint.getText()+ "\n");
            this.selectedText = this.stringToPaint.getText();
            this.selectedFont = (String) this.availableFonts.getSelectedItem();
            this.selectedSize = (String) this.fontSizes.getSelectedItem();
            return 0;
        } else if (result == CANCEL_OPTION) {
            return 1;
        } else if (result == CLOSED_OPTION) {
            return 1;
        } else {
            return 1;
        }
    }
}