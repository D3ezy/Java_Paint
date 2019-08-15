package cs338.gui.ribbon;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class RibbonClipboardView extends JPanel {

    private static final long serialVersionUID = 1L;
    JButton paste, cut, copy;
    JPanel inner_clipboard;

    RibbonClipboardView() {
        super();
        this.setLayout(new BorderLayout());
        initComponents();
        prepareIcons();
    }

    public void initComponents() {

        // layout
        inner_clipboard = new JPanel();
        inner_clipboard.setLayout(new BoxLayout(inner_clipboard, BoxLayout.Y_AXIS));

        // labels
        JLabel clipboardLabel = new JLabel("Clipboard", SwingConstants.CENTER);

        // buttons
        paste = new JButton("Paste");
        cut = new JButton("Cut");
        copy = new JButton("Copy");

        // add components
        inner_clipboard.add(cut);
        inner_clipboard.add(copy);

        this.add(paste, BorderLayout.CENTER);
        this.add(inner_clipboard, BorderLayout.EAST);
        this.add(clipboardLabel, BorderLayout.SOUTH);
    }

    private void prepareIcons() {
        FontIcon paste_icon = FontIcon.of(FontAwesomeSolid.PASTE, Color.BLACK);
        FontIcon cut_icon = FontIcon.of(FontAwesomeSolid.CUT, Color.BLACK);
        FontIcon copy_icon = FontIcon.of(FontAwesomeSolid.COPY, Color.BLACK);
        paste.setIcon(paste_icon);
        cut.setIcon(cut_icon);
        copy.setIcon(copy_icon);
    }

}