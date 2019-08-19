package cs338.gui.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class ImageShape extends Shape {

    BufferedImage img;

    public ImageShape(Color mycolor, Point mypoint, int brushX, int brushY, BufferedImage load) {
        super(mycolor, mypoint, brushX, brushY);
        this.img = load;
    }

	@Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
	}
    
}