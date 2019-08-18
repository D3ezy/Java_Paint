package cs338.gui.canvas;

public class PaintBrush implements Brush {

    private int brushX, brushY;

    public PaintBrush(int brushSize) {
        // default Paint Brush sizee
        this.brushX = brushSize;
        this.brushY = brushSize+20;
    }

    @Override
    public int getBrushX() {
        return this.brushX;
    }

    @Override
    public int getBrushY() {
        return this.brushY;
    }

    @Override
    public void changeBrushSize(int newSize) {
        this.brushX = newSize;
        this.brushY = newSize+20;
        return;
    }
}