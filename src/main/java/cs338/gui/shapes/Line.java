package cs338.gui.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Line extends Shape {

	private int x2,y2;

    public Line(Color mycolor, Point mypoint, int brushX, int brushY, int x, int y) {
		super(mycolor, mypoint, brushX, brushY);
		this.x2 = x;
		this.y2 = y;
	}

    @Override
    public void paint(Graphics g) {
        g.setColor(this.color);
        g.drawLine(this.point.x, this.point.y, this.x2, this.y2);
	}
    
}