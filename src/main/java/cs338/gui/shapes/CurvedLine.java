package cs338.gui.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class CurvedLine extends Shape {

    public CurvedLine(Color mycolor, Point mypoint, int brushX, int brushY) {
		super(mycolor, mypoint, brushX, brushY);
	}

    @Override
    public void paint(Graphics g) {
        g.setColor(this.color);
        g.fillOval(this.point.x, this.point.y, this.x, this.y);
    }    
}