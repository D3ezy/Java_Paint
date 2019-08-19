package cs338.gui.canvas;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import cs338.gui.MainFrame;
import cs338.gui.ribbon.RibbonView;
import cs338.gui.shapes.CurvedLine;
import cs338.gui.shapes.HighlighterLine;
import cs338.gui.shapes.ImageShape;
import cs338.gui.shapes.Line;
import cs338.gui.shapes.Oval;
import cs338.gui.shapes.Rectangle;
import cs338.gui.shapes.Shape;
import cs338.gui.shapes.TextShape;
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

import static cs338.gui.ribbon.RibbonView.tools;
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
    private static int W = 750;
    private static int H = 750;

    // attirbutes
    private ArrayList<Shape> shapes;
    private Integer lineCount;
    private Stack<Integer> allLineCounts;
    private Stack<ArrayList<Shape>> redoStack;
    private Brush currBrush;
    private JColorChooser my_colors;
    private boolean hasBeenSaved, hasBeenDrawn, hasLoaded;
    private Tool currentTool;
    private Point start = null;
    private Point end = null;

    // default constructor
    public PaintCanvasView() {
        super();
        this.shapes = new ArrayList<>();
        this.redoStack = new Stack<>();
        this.lineCount = 0;
        this.allLineCounts = new Stack<>();
        this.my_colors = RibbonView.getPallette();
        this.currBrush = new PencilBrush(5);
        this.currentTool = Tool.PENCIL;
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

    public void setBackground() {
        this.setBackground(my_colors.getColor());
        repaint();
        return;
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
        W = 2000;
        H = 2000;
        this.getPreferredSize();
        this.setVisible(true);
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
        this.redoStack.clear();
        MainFrame.menubar.disableRedo();
        tools.disableRedo();
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
        Integer lastLineCount = allLineCounts.pop();
        int sizeOfShapes = shapes.size();
        ArrayList<Shape> redoLine = new ArrayList<>();
        for (int i= 0; i < lastLineCount; i++) {
            redoLine.add(shapes.get(sizeOfShapes-1-i));
            shapes.remove(sizeOfShapes-1-i);
        }
        redoStack.push(redoLine);
        if (allLineCounts.isEmpty()) {
            MainFrame.menubar.disableUndo();
            tools.disableUndo();
        }
        MainFrame.menubar.enableRedo();
        tools.enableRedo();
        this.repaint();
    }

    public void redo() {
        ArrayList<Shape> redo = redoStack.pop();
        allLineCounts.push(redo.size());
        for(int i =0; i<redo.size(); i++) {
            shapes.add(redo.get(i));
        }
        if (redoStack.isEmpty()) {
            MainFrame.menubar.disableRedo();
            tools.disableRedo();
        }
        MainFrame.menubar.enableUndo();
        tools.enableUndo();
        this.repaint();
    }

    public void setColor(Color c) {
        this.my_colors.setColor(c);
        return;
    }

    public boolean hasFileBeenLoaded() {
        return this.hasLoaded;
    }

    public void setHasBeenDrawn(boolean value) {
        this.hasBeenDrawn = value;
        return;
    }

    public void setCurrentTool(Tool newTool) {
        this.currentTool = newTool;
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
        Shape s = null;
        if (this.currentTool == Tool.PENCIL) {
            s = new CurvedLine(my_colors.getColor(), e.getPoint(), this.currBrush.getBrushX(), this.currBrush.getBrushY());
        } else if (currentTool == Tool.ERASER) {
            s = new CurvedLine(Color.WHITE, e.getPoint(), this.currBrush.getBrushX(), this.currBrush.getBrushY());
        } else if (currentTool == Tool.FONT) {
            return;
        } else if (currentTool == Tool.PAINTCAN) {
            return;
        } else if (currentTool == Tool.LINE) {
            this.end = e.getPoint();
            s = new Line(my_colors.getColor(), this.start, this.currBrush.getBrushX(), this.currBrush.getBrushY(), this.end);
            this.start = this.end;
        } else if (currentTool == Tool.RECTANGLE) {
            s = new Rectangle(my_colors.getColor(), this.start, this.currBrush.getBrushX(), this.currBrush.getBrushY(),e.getPoint());
        } else if (currentTool == Tool.OVAL) {
            s = new Oval(my_colors.getColor(), this.start, this.currBrush.getBrushX(), this.currBrush.getBrushY(),e.getPoint());
        } else if (currentTool == Tool.HIGHLIGHTER) {
            Color newcolor = new Color(my_colors.getColor().getRed(),my_colors.getColor().getGreen(),my_colors.getColor().getBlue(), 10);
            s = new HighlighterLine(newcolor, e.getPoint(), this.currBrush.getBrushX(), this.currBrush.getBrushY());
        }
        shapes.add(s);
        lineCount++;
        System.out.println("Current line count: " + lineCount);
        repaint();
    }

    @Override
	public void mousePressed(MouseEvent e) {
        Shape s = null;
        if (currentTool == Tool.LINE) {
            start = e.getPoint();
            s = new Line(my_colors.getColor(), this.start, this.currBrush.getBrushX(), this.currBrush.getBrushY(), this.start);
            return;
        } else if (currentTool == Tool.RECTANGLE) {
            start = e.getPoint();
            s = new Rectangle(my_colors.getColor(), start, this.currBrush.getBrushX(), this.currBrush.getBrushY(), new Point(e.getPoint().x, e.getPoint().y));
        } else if (currentTool == Tool.OVAL) {
            start = e.getPoint();
            s = new Oval(my_colors.getColor(), start, this.currBrush.getBrushX(), this.currBrush.getBrushY(),new Point(e.getPoint().x, e.getPoint().y));
        } else {
            return;
        }
        shapes.add(s);
        lineCount++;
        repaint();
    }

    @Override
	public void mouseClicked(MouseEvent e) {
        Shape s = null;
        if (this.currentTool == Tool.PENCIL) {
            s = new CurvedLine(my_colors.getColor(), e.getPoint(), this.currBrush.getBrushX(), this.currBrush.getBrushY());
        } else if (currentTool == Tool.ERASER) {
            s = new CurvedLine(Color.WHITE, e.getPoint(), this.currBrush.getBrushX(), this.currBrush.getBrushY());
        } else if (currentTool == Tool.FONT) {
            FontChooserView fcv = new FontChooserView();
            fcv.setVisible(true);
            System.out.println(fcv.getFontType().toString());
            s = new TextShape(my_colors.getColor(), e.getPoint(), this.currBrush.getBrushX(), this.currBrush.getBrushY(),fcv.getText(), fcv.getFontType());
        } else if (this.currentTool == Tool.PAINTCAN) {
            this.setBackground();
            return;
        } else if (this.currentTool == Tool.HIGHLIGHTER) {
            Color newcolor = new Color(my_colors.getColor().getRed(),my_colors.getColor().getGreen(),my_colors.getColor().getBlue(), 10);
            s = new HighlighterLine(newcolor, e.getPoint(), this.currBrush.getBrushX(), this.currBrush.getBrushY());
        } else {
            return;
        }
        shapes.add(s);
        lineCount++;
        System.out.println("Current line count: " + lineCount);
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
        this.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.hasBeenDrawn = true;
        MainFrame.menubar.enableUndo();
        tools.enableUndo();
        Integer count = lineCount;
        allLineCounts.push(count);
        lineCount = 0;
        repaint();
        return;
    }

    // unused
    @Override
    public void componentMoved(ComponentEvent e) {}
    @Override
    public void componentShown(ComponentEvent e) {}
    @Override
    public void componentHidden(ComponentEvent e) {}
}