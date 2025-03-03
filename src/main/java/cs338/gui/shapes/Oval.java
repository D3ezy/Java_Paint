package cs338.gui.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Oval extends Shape {

    Point end;

    public Oval(Color mycolor, Point mypoint, int brushX, int brushY, Point endpoint, int zoom) {
        super(mycolor, mypoint, brushX, brushY, zoom);
        this.end = endpoint;
    }

	@Override
    public void paint(Graphics g) {
        g.setColor(this.color);
        g.drawOval(point.x, point.y, end.x-point.x, end.y-point.y);
	}
    
}