package cs338.gui.ribbon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import cs338.gui.subwindows.ColorChooserWindowView;

public class RibbonColorChooserView extends JPanel {

    private static final long serialVersionUID = 1L;
    private JButton openChooser;
    private JColorChooser pallette;

    RibbonColorChooserView() {
        super();
        this.setLayout(new BorderLayout());
        initComponents();
        prepareIcons();
    }

    public void initComponents() {

        // init inner layouts
        JPanel inner_color = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Labels
        JLabel colorsLabel = new JLabel("Colors", SwingConstants.CENTER);

        //  Color Pallette
        pallette = new JColorChooser(Color.RED);
        pallette.setPreviewPanel(new JPanel());
        AbstractColorChooserPanel[] panels = pallette.getChooserPanels();
        pallette.getSelectionModel().addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
            }
        });
        openChooser = new JButton("Open Color Chooser");
        openChooser.setToolTipText("Opens Advanced Color options window");
        openChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ColorChooserWindowView jc = new ColorChooserWindowView(pallette.getColor());
                jc.setVisible(true);
                jc.me.getSelectionModel().addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        pallette.setColor(jc.me.getColor());
                    }
                });
            }
        });

        // add components
        for (AbstractColorChooserPanel accp : panels) {
            if (accp.getDisplayName().equals("Swatches")) {
                inner_color.add(accp);
            }
        }
        inner_color.add(openChooser);
        this.add(colorsLabel, BorderLayout.SOUTH);
        this.add(inner_color, BorderLayout.CENTER);
    }

    public void prepareIcons() {
        FontIcon openChooser_icon = FontIcon.of(FontAwesomeSolid.PAINT_BRUSH, Color.BLACK);
        openChooser.setIcon(openChooser_icon);
    }

    public JColorChooser getPallette() {
        return this.pallette;
    }

}