package cs338.gui.canvas;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import cs338.gui.MainFrame;
import cs338.gui.ribbon.RibbonView;
import cs338.gui.shapes.CurvedLine;
import cs338.gui.shapes.ImageShape;
import cs338.gui.shapes.Shape;
import cs338.gui.subwindows.FileNotSavedDialogView;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
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
    private ArrayList<Shape> currLine;
    private Stack<ArrayList<Shape>> completedLines;
    private Stack<ArrayList<Shape>> redoStack;
    private Brush currBrush;
    private JColorChooser my_colors;
    private boolean hasBeenSaved, hasBeenDrawn, hasLoaded;

    // default constructor
    public PaintCanvasView() {
        super();
        this.shapes = new ArrayList<>();
        this.currLine = new ArrayList<>();
        this.redoStack = new Stack<>();
        this.completedLines = new Stack<>();
        this.my_colors = RibbonView.getPallette();
        this.currBrush = new PencilBrush(5);
        this.hasBeenDrawn = false;
        this.hasBeenSaved = false;
        this.hasLoaded = false;
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
        this.hasBeenSaved = true;
    }

    public void loadImage(String name) {
        // clear panel first
        this.clear();

        // attempt to load image
        BufferedImage loadImg = null;
        try {
            loadImg = ImageIO.read(new File(name));
            Shape image = new ImageShape(null, null, 0, 0, loadImg);
            this.shapes.add(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.repaint();
        this.hasLoaded = true;
    }

    public void rotate() {
        for(int i = 0; i<this.shapes.size(); i++) {
        }
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
        if (hasBeenDrawn == true && hasBeenSaved == false) {
            FileNotSavedDialogView notSaved = new FileNotSavedDialogView();
            notSaved.setVisible(true);
            if(notSaved.handle() == 1) {
                return;
            }
        }
        this.removeAll();
        this.revalidate();
        this.shapes.clear();
        this.hasBeenDrawn = false;
        this.hasBeenSaved = false;
        this.repaint();
        return;
    }

    public void changeBrush(Brush newBrush) {
        this.currBrush = newBrush;
        return;
    }

    // undo/redo
    public void undo() {
        if(this.completedLines.size() == 0) {
            System.out.println("Nothing to undo.");
            return;
        }
        // pop last Completed Line off Stack
        ArrayList<Shape> undoLine = this.completedLines.pop();
        this.redoStack.add(undoLine);
        int sizeOfLine = undoLine.size();
        int sizeOfShapes = this.shapes.size();
        for (int i =0; i<sizeOfLine; i++) {
            this.shapes.remove(sizeOfShapes-1-i);
            this.shapes.trimToSize();
            sizeOfShapes = this.shapes.size();
        }     
        MainFrame.menubar.enableRedo();
        this.repaint();
    }

    public void redo() {
        ArrayList<Shape> redoLine = this.redoStack.pop();
        for (int i = 0; i < redoLine.size(); i++) {
            this.shapes.add(redoLine.get(i));
        }
        this.repaint();
    }

    public int getRedoStackSize() {
        return this.redoStack.size();
    }

    public void setColor(Color c) {
        this.my_colors.setColor(Color.WHITE);
        return;
    }

    public boolean hasFileBeenLoaded() {
        return this.hasLoaded;
    }

    public void setHasBeenDrawn(boolean value) {
        this.hasBeenDrawn = value;
        return;
    }

    // -----------------------------------------------------------------
    // ---- Inherited/Overridden Methods
    // -----------------------------------------------------------------

    @Override
    public void paintComponent(Graphics g) {
        MainFrame.menubar.enableUndo();
        super.paintComponent(g);
        for(Shape s : shapes) {
            s.paint(g);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Shape s = new CurvedLine(my_colors.getColor(), e.getPoint(), this.currBrush.getBrushX(), this.currBrush.getBrushY());
        shapes.add(s);
        currLine.add(s);
        repaint();
    }

    @Override
	public void mouseClicked(MouseEvent e) {
        System.out.println(e.getPoint());
        Shape s = new CurvedLine(my_colors.getColor(), e.getPoint(), this.currBrush.getBrushX(), this.currBrush.getBrushY());
        shapes.add(s);
        currLine.add(s);
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

    @Override
    public void mouseReleased(MouseEvent e) {
        this.hasBeenDrawn = true;
        Shape s = new CurvedLine(my_colors.getColor(), e.getPoint(), this.currBrush.getBrushX(), this.currBrush.getBrushY());
        currLine.add(s);
        this.completedLines.push(this.currLine);
        this.currLine.clear();
        return;
    }

    // unused
	@Override
	public void mousePressed(MouseEvent e) {}
    @Override
    public void componentMoved(ComponentEvent e) {}
    @Override
    public void componentShown(ComponentEvent e) {}
    @Override
    public void componentHidden(ComponentEvent e) {}
}