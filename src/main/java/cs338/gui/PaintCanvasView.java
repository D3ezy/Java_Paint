package cs338.gui;

import javax.swing.JColorChooser;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PaintCanvasView extends JPanel implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;
    private int startX, startY, endX, endY;
    private JColorChooser my_colors;
    private Graphics2D g; 

    public PaintCanvasView(JColorChooser paintChooser) {
        super();
        my_colors = paintChooser;
        setDoubleBuffered(false);
        addMouseListener(this);
        addMouseMotionListener(this);
        initComponents();
    }

    public void initComponents() {
        this.setSize(this.getPreferredSize());
        this.setBackground(Color.WHITE);
    }

    // -----------------------------------------------------------------
    // ---- Implemented Methods
    // -----------------------------------------------------------------

    public Dimension getPreferredSize() {
        return new Dimension(600,550);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(startX, startY, endX, endY);
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.endX = e.getX();
        this.endY = e.getY();
        if (g != null) {
            g.drawLine(startX, startY, endX, endY);
            repaint();
            this.startX = this.endX;
            this.startY = this.endY;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.startX = e.getX();
        this.startY = e.getY();
    }

    // unused
    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

}