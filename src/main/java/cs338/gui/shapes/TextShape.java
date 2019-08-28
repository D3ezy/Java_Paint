package cs338.gui.shapes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

public class TextShape extends Shape {

    String text;
    int size;
    Font fontToUse;

    public TextShape(Color mycolor, Point mypoint, int brushX, int brushY, String s, Font f, int zoom) {
        super(mycolor, mypoint, brushX, brushY, zoom);
        this.text = s;
        this.fontToUse= f;
    }

	@Override
    public void paint(Graphics g) {
        g.setColor(this.color);
        g.setFont(this.fontToUse);
		g.drawString(text, point.x, point.y);
	}
    
}