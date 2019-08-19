package cs338.gui.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class HighlighterLine extends Shape {

    public HighlighterLine(Color mycolor, Point mypoint, int brushX, int brushY) {
		super(mycolor, mypoint, brushX, brushY);
	}

    @Override
    public void paint(Graphics g) {
		if (point != null) {
			g.setColor(this.color);
			g.drawRect(this.point.x, this.point.y, this.x, this.y);
		}
    }
    
}