package cs338.gui.ribbon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.kordamp.ikonli.fontawesome5.FontAwesomeRegular;
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
        eraser = new JButton("E");
        font = new JButton("F");
        magnify = new JButton("M");
        dropper = new JButton("D");
        paintcan = new JButton("C");

        // add components
        ribbon_inner_tools.add(pencil);
        ribbon_inner_tools.add(magnify);
        ribbon_inner_tools.add(eraser);
        ribbon_inner_tools.add(font);
        ribbon_inner_tools.add(dropper);
        ribbon_inner_tools.add(paintcan);

        this.add(ribbon_inner_tools, BorderLayout.NORTH);
        this.add(toolsLabel, BorderLayout.SOUTH);
    }

    private void prepareIcons() {
        FontIcon pencil_icon = FontIcon.of(FontAwesomeSolid.PENCIL_ALT, Color.BLACK);
        pencil.setIcon(pencil_icon);
    }

}