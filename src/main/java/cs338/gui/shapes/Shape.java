package cs338.gui.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {

    protected Color color;
    protected Point point;
    protected int x, y;

    public Shape(Color mycolor, Point mypoint, int brushX, int brushY) {
        this.color = mycolor;
        this.point = mypoint;
        this.x = brushX;
        this.y = brushY;
    }

    public Point getPoint() {
        return this.point;
    }

    public Color getColor() {
        return this.color;
    }

    public void setPoint(Point p) {
        this.point = p;
    }

    public abstract void paint(Graphics g);

}