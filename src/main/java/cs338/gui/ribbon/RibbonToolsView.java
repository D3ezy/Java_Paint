package cs338.gui.ribbon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

public class RibbonToolsView extends JPanel {

    private static final long serialVersionUID = 1L;
    JPanel ribbon_inner_tools;
    JButton pencil, magnify, eraser, font, dropper, paintcan;

    RibbonToolsView() {
        super();
        this.setLayout(new BorderLayout());
        initComponents();
        prepareIcons();
    }

    public void initComponents() {

        // inner layout
        ribbon_inner_tools = new JPanel();
        GridLayout inner_tools_layout = new GridLayout(2,3);
        ribbon_inner_tools.setLayout(inner_tools_layout);

        // labels
        JLabel toolsLabel = new JLabel("Tools", SwingConstants.CENTER);

        // buttons
        pencil = new JButton();
        pencil.setPressedIcon(null);
        eraser = new JButton();
        font = new JButton();
        magnify = new JButton();
        dropper = new JButton();
        paintcan = new JButton("C");

        // add components
        ribbon_inner_tools.add(pencil);
        ribbon_inner_tools.add(magnify);
        ribbon_inner_tools.add(eraser);
        ribbon_inner_tools.add(font);
        ribbon_inner_tools.add(dropper);
        ribbon_inner_tools.add(paintcan);

        this.add(ribbon_inner_tools, BorderLayout.CENTER);
        this.add(toolsLabel, BorderLayout.SOUTH);
    }

    private void prepareIcons() {
        FontIcon pencil_icon = FontIcon.of(FontAwesomeSolid.PENCIL_ALT, Color.BLACK);
        FontIcon eraser_icon = FontIcon.of(FontAwesomeSolid.ERASER, Color.BLACK);
        FontIcon text_icon = FontIcon.of(FontAwesomeSolid.FONT, Color.BLACK);
        FontIcon magnify_icon = FontIcon.of(FontAwesomeSolid.SEARCH_PLUS, Color.BLACK);
        FontIcon dropper_icon = FontIcon.of(FontAwesomeSolid.EYE_DROPPER, Color.BLACK);
        // FontIcon paintcan_icon = FontIcon.of(FontAwesomeSolid.FILL_DRIP, Color.BLACK);
        pencil.setIcon(pencil_icon);
        eraser.setIcon(eraser_icon);
        font.setIcon(text_icon);
        magnify.setIcon(magnify_icon);
        dropper.setIcon(dropper_icon);

    }

}