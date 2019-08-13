package cs338.gui;

import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;;

public class InfoBar extends JPanel implements MouseListener {

    int canvasX, canvasY, currX, currY, selectionX, selectionY;
    ImageIcon currPosIcon, canvasSizeIcon, selectionAreaIcon;
    JLabel pointPos, canvasSize, selectionSize, zoomAmt;
    JSlider zoomSlider;
    JSeparator sep1,sep2,sep3,sep4,sep5;

    InfoBar() {
        super();
        this.addMouseListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.initComponents();
    }

    // -----------------------------------------------------------------
    // ---- Implemented Methods
    // -----------------------------------------------------------------

    // Layouts the info panel
    public void initComponents() {
        pointPos = new JLabel("Shows current pointer position");
        canvasSize = new JLabel("Shows canvas size");
        selectionSize = new JLabel("Shows size of curr selection");
        zoomSlider = new JSlider(SwingConstants.HORIZONTAL, 12, 800, 100);
        sep1 = new JSeparator(SwingConstants.VERTICAL);
        sep2 = new JSeparator(SwingConstants.VERTICAL);
        sep3 = new JSeparator(SwingConstants.VERTICAL);
        sep4 = new JSeparator(SwingConstants.VERTICAL);
        sep5 = new JSeparator(SwingConstants.VERTICAL);

        // Layout
        JPanel pointerPosition = new JPanel(new BorderLayout());
        JPanel selectionCoord = new JPanel(new BorderLayout());
        JPanel canvasSize = new JPanel(new BorderLayout());
        JPanel sliderPane = new JPanel(new BorderLayout());

        // add components to panels
        pointerPosition.add(this.pointPos, BorderLayout.WEST);
        selectionCoord.add(this.selectionSize, BorderLayout.WEST);
        canvasSize.add(this.canvasSize, BorderLayout.WEST);
        sliderPane.add(this.zoomSlider, BorderLayout.CENTER);

        // add panels to main
        this.add(pointerPosition);
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(sep1);
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(selectionCoord);
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(sep2);
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(canvasSize);
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(sep3);
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(sliderPane);

        return;
    }

    // used for the listener to update the canvas size
    public void setCanvasSize(int width, int height) {
        this.canvasX = width;
        this.canvasY = height;
        return;
    }

    // used for the listener to update the selection size
    public void setSelectionArea(int width, int height) {
        this.selectionX = width;
        this.selectionY = height;
        return;
    }

    // -----------------------------------------------------------------
    // ---- MouseListener
    // -----------------------------------------------------------------

    // used for when the mouse enters the canvas area, set initial position
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    // used for when the mouse exits the canvas area, clear the label
    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    // not needed
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
}