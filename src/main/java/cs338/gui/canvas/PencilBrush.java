package cs338.gui.canvas;

public class PencilBrush implements Brush {

    private int brushSize;

    public PencilBrush(int bs) {
        this.brushSize = bs;
    }

    @Override
    public int getBrushX() {
        return this.brushSize;
    }

    @Override
    public int getBrushY() {
        return this.brushSize;
    }

    @Override
    public void changeBrushSize(int newSize) {
        this.brushSize = newSize;
        return;
    }

}