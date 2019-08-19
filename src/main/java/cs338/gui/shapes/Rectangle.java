package cs338.gui.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Shape {

    Point end;

    public Rectangle(Color mycolor, Point mypoint, int brushX, int brushY, Point endpoint) {
        super(mycolor, mypoint, brushX, brushY);
        this.end = endpoint;
    }

	@Override
    public void paint(Graphics g) {
        g.setColor(this.color);
        g.drawRect(point.x, point.y, end.x-point.x, end.y-point.y);
	}
    
}