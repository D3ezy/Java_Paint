package cs338.gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;

public class InfoBarView extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    JLabel pointPos, canvasSize, zoomAmt;
    JSlider zoomSlider;
    JButton zoomPlus, zoomMinus;
    JSeparator sep1,sep2,sep3,sep4,sep5;
    JPanel pointerPosition, canvSize, sliderPane;
    int count;

    InfoBarView() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBorder(BorderFactory.createCompoundBorder(new EtchedBorder(EtchedBorder.RAISED), new EmptyBorder(5,5,5,5)));
        this.initComponents();
        this.prepareIcons();
    }

    // -----------------------------------------------------------------
    // ---- Implemented Methods
    // -----------------------------------------------------------------

    // Layouts the info panel
    public void initComponents() {
        count = 1;
        pointPos = new JLabel("Shows current pointer position");
        canvasSize = new JLabel("Shows canvas size");
        zoomSlider = new JSlider(SwingConstants.HORIZONTAL);
        zoomSlider.setValue(1);
        zoomSlider.setMinimum(1);
        zoomSlider.setMaximum(10);
        zoomSlider.setMinorTickSpacing(1);
        zoomSlider.setMajorTickSpacing(1);
        zoomSlider.setPaintTicks(true);
        zoomSlider.setSnapToTicks(true);
        zoomSlider.setToolTipText("Zooms in/out on canvas");
        pointPos.setToolTipText("Shows the current pointer position on canvas");
        canvasSize.setToolTipText("Current size of canvas");
        sep1 = new JSeparator(SwingConstants.VERTICAL);
        sep2 = new JSeparator(SwingConstants.VERTICAL);
        sep3 = new JSeparator(SwingConstants.VERTICAL);
        sep4 = new JSeparator(SwingConstants.VERTICAL);
        sep5 = new JSeparator(SwingConstants.VERTICAL);
        zoomPlus = new JButton();
        zoomMinus = new JButton();

        // Layout
        pointerPosition = new JPanel(new BorderLayout());
        canvSize = new JPanel(new BorderLayout());
        sliderPane = new JPanel(new BorderLayout());

        this.pointerPosition.setPreferredSize(new Dimension(100,35));
        this.zoomSlider.setPreferredSize(new Dimension(50,35));

        // add components to panels
        pointerPosition.add(this.pointPos, BorderLayout.WEST);
        canvSize.add(this.canvasSize, BorderLayout.WEST);
        sliderPane.add(this.zoomSlider, BorderLayout.CENTER);
        sliderPane.add(this.zoomPlus, BorderLayout.EAST);
        sliderPane.add(this.zoomMinus, BorderLayout.WEST);

        zoomPlus.addActionListener(this);
        zoomMinus.addActionListener(this);
        zoomSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                System.out.println("Slider: " + zoomSlider.getValue());
			}
        });

        // add panels to main
        this.add(pointerPosition);
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(sep1);
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(canvasSize);
        this.add(Box.createRigidArea(new Dimension(120,0)));
        this.add(sep3);
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(sliderPane);

        return;
    }

    public void clearPtrLocation() {
        this.pointPos.setText("");
        return;
    }

    public void updateCanvasSize(int width, int height) {
        this.canvasSize.setText(width + " x " + height + "px");
        return;
    }

    public void updatePtrLocation(int location_x, int location_y) {
        this.pointPos.setText(location_x + "," + location_y +"px");
    }

    public void prepareIcons() {
        FontIcon canvasSizeIcon = FontIcon.of(FontAwesomeSolid.OBJECT_GROUP, Color.BLACK);
        FontIcon ptrLocationIcon = FontIcon.of(FontAwesomeSolid.EXPAND_ARROWS_ALT, Color.BLACK);
        FontIcon zoomPlusIcon = FontIcon.of(FontAwesomeSolid.PLUS_CIRCLE, Color.BLACK);
        FontIcon zoomMinusIcon = FontIcon.of(FontAwesomeSolid.MINUS_CIRCLE, Color.BLACK);
        this.zoomPlus.setIcon(zoomPlusIcon);
        this.zoomMinus.setIcon(zoomMinusIcon);
        this.canvasSize.setIcon(canvasSizeIcon);
        this.pointPos.setIcon(ptrLocationIcon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == zoomPlus) {
            if (count < this.zoomSlider.getMaximum()) {
                this.zoomSlider.setValue(this.zoomSlider.getValue()+1);
                MainFrame.canvas.zoomIn();
                count++;
            }
        } else if (e.getSource() == zoomMinus) {
            if (count > this.zoomSlider.getMinimum()) {
                this.zoomSlider.setValue(this.zoomSlider.getValue()-1);
                MainFrame.canvas.zoomOut();
                count--;
            }
        }
	}
}