package cs338.gui.canvas;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import cs338.gui.MainFrame;
import cs338.gui.ribbon.RibbonView;
import cs338.gui.shapes.CurvedLine;
import cs338.gui.shapes.Shape;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Robot;

public class PaintCanvasView extends JPanel implements MouseListener, MouseMotionListener, ComponentListener {

    // constants
    private static final long serialVersionUID = 1L;
    private static final int W = 600;
    private static final int H = 550;

    // attirbutes
    private ArrayList<Shape> shapes;
    private Brush currBrush;
    private JColorChooser my_colors;

    // default constructor
    public PaintCanvasView() {
        super();
        this.shapes = new ArrayList<>();
        this.my_colors = RibbonView.getPallette();
        this.currBrush = new PencilBrush(5);
        setDoubleBuffered(false);
        addComponentListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        initComponents();
    }

    // initialize subsequent components
    public void initComponents() {
        this.setSize(this.getPreferredSize());
        this.setBackground(Color.WHITE);
    }

    // save/load
    public void saveImage(String name) {
        BufferedImage imgBuffer = null;
        try{
            imgBuffer = new Robot().createScreenCapture(this.getBounds());
        } catch (AWTException e) {
            e.printStackTrace();
        }

        Graphics2D out = imgBuffer.createGraphics();
        this.paintComponent(out);
        try {
            ImageIO.write(imgBuffer, "jpeg", new File(name + ".jpeg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadImage(String name) {
        // clear panel first
        this.clear();

        // attempt to load image
        BufferedImage loadImg = null;
        try {
            loadImg = ImageIO.read(new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Graphics g = this.getGraphics();
        g.drawImage(loadImg, 0, 0, null);
    }

    // getters/setters
    public Dimension getPreferredSize() {
        return new Dimension(W,H);
    }

    public void updateCanvasSize(Dimension newSize) {
        this.setPreferredSize(newSize);
        return;
    }

    public Brush getCurrentBrush() {
        return this.currBrush;
    }

    // clears canvas
    public void clear() {
        this.removeAll();
        this.revalidate();
        this.shapes.clear();
        this.repaint();
        return;
    }

    public void changeBrush(Brush newBrush) {
        this.currBrush = newBrush;
        return;
    }

    // -----------------------------------------------------------------
    // ---- Inherited/Overridden Methods
    // -----------------------------------------------------------------

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Shape s : shapes) {
            s.paint(g);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        shapes.add(new CurvedLine(my_colors.getColor(), e.getPoint(), this.currBrush.getBrushX(), this.currBrush.getBrushY()));
        repaint();
    }

    @Override
	public void mouseClicked(MouseEvent e) {
        shapes.add(new CurvedLine(my_colors.getColor(), e.getPoint(), this.currBrush.getBrushX(), this.currBrush.getBrushY()));
        repaint();
    }
    
    @Override
	public void mouseExited(MouseEvent e) {
       MainFrame.info_bar.clearPtrLocation();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point currPoint = e.getPoint();
        MainFrame.info_bar.updatePtrLocation(currPoint.x, currPoint.y);
    }

    @Override
	public void mouseEntered(MouseEvent e) {
        Point currPoint = e.getPoint();
        MainFrame.info_bar.updatePtrLocation(currPoint.x, currPoint.y);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        int h = e.getComponent().getHeight();
        int w = e.getComponent().getWidth();
        MainFrame.info_bar.updateCanvasSize(w, h);
    }

    // unused
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void componentMoved(ComponentEvent e) {}
    @Override
    public void componentShown(ComponentEvent e) {}
    @Override
    public void componentHidden(ComponentEvent e) {}
}