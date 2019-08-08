package cs338.gui;

import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class PaintCanvas extends JPanel implements MouseListener, MouseMotionListener {

    private int oldX, oldY, currX, currY;

    PaintCanvas() {
        super();
        this.setSize(this.getPreferredSize());
        this.addMouseListener(this);
        this.setBackground(Color.WHITE);
    }

    // -----------------------------------------------------------------
    // ---- Implemented Methods
    // -----------------------------------------------------------------

    public Dimension getPreferredSize() {
        return new Dimension(400,350);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(currX, currY, oldX, oldY);
    }

    // -----------------------------------------------------------------
    // ---- MouseMotionListener
    // -----------------------------------------------------------------

    @Override
    public void mouseDragged(MouseEvent e) {
        oldX = e.getX();
        oldY = e.getY();
        currX = oldX;
        currY = oldY;
        repaint();
        return;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    // -----------------------------------------------------------------
    // ---- MouseListener
    // -----------------------------------------------------------------

    @Override
    public void mouseClicked(MouseEvent e) {
        currX = e.getX();
        currY = e.getY();
        repaint();
        return;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // mouse pressed original coordinates
        oldX = e.getX();
        oldY = e.getY();
        return;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

}