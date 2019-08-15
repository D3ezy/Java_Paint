package cs338.gui;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class PaintCanvasView extends JPanel {

    private static final long serialVersionUID = 1L;
    thinLine thin = new thinLine();

    public PaintCanvasView() {
        super();
        this.setSize(this.getPreferredSize());
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                moveLine(e.getX(), e.getY());
            }
        });
        this.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e) {
                moveLine(e.getX(), e.getY());
            }
        });
        this.setBackground(Color.WHITE);
    }

    // -----------------------------------------------------------------
    // ---- Implemented Methods
    // -----------------------------------------------------------------

    public Dimension getPreferredSize() {
        return new Dimension(600,550);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        thin.paintLine(g);
    }

    public void moveLine(int x, int y) {
        
        // Current square state, stored as final variables 
        // to avoid repeat invocations of the same methods.
        final int CURR_X = thin.getX();
        final int CURR_Y = thin.getY();
        final int CURR_W = thin.getWidth();
        final int CURR_H = thin.getHeight();
        final int OFFSET = 1;

        if ((CURR_X!=x) || (CURR_Y!=y)) {

            // The square is moving, repaint background 
            // over the old square location. 
            repaint(CURR_X,CURR_Y,CURR_W+OFFSET,CURR_H+OFFSET);

            // Update coordinates.
            thin.setX(x);
            thin.setY(y);

            // Repaint the square at the new location.
            repaint(thin.getX(), thin.getY(), 
                    thin.getWidth()+OFFSET, 
                    thin.getHeight()+OFFSET);
        }
    }

}

class thinLine {

    private int xPos = 50;
    private int yPos = 50;
    private int width = 20;
    private int height = 20;

    public void setX(int xPos){ 
        this.xPos = xPos;
    }

    public int getX(){
        return xPos;
    }

    public void setY(int yPos){
        this.yPos = yPos;
    }

    public int getY(){
        return yPos;
    }

    public int getWidth(){
        return width;
    } 

    public int getHeight(){
        return height;
    }

    public void paintLine(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(xPos,yPos,width,height);
        g.setColor(Color.BLACK);
        g.drawRect(xPos,yPos,width,height);  
    }
}