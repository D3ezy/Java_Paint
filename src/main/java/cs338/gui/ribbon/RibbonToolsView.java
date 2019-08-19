package cs338.gui.ribbon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import cs338.gui.canvas.Tool;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import cs338.gui.MainFrame;

public class RibbonToolsView extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    JPanel ribbon_inner_tools;
    JToggleButton pencil, highlighter, eraser, font, shape, paintcan;
    JButton undo, redo;
    ButtonGroup bg; 

    RibbonToolsView() {
        super();
        this.setLayout(new BorderLayout());
        initComponents();
        prepareIcons();
    }

    public void initComponents() {

        // inner layout
        ribbon_inner_tools = new JPanel();
        GridLayout inner_tools_layout = new GridLayout(2,4);
        ribbon_inner_tools.setLayout(inner_tools_layout);
        ribbon_inner_tools.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        // labels
        JLabel toolsLabel = new JLabel("Tools", SwingConstants.CENTER);

        // buttongroup
        this.bg = new ButtonGroup();

        // buttons
        pencil = new JToggleButton();
        pencil.setToolTipText("Draw on canvas with brush");
        eraser = new JToggleButton();
        eraser.setToolTipText("Erase drawings on canvas");
        font = new JToggleButton();
        font.setToolTipText("Type font on canvas");
        highlighter = new JToggleButton();
        highlighter.setToolTipText("Highlight drawings on canvas");
        this.highlighter.setEnabled(true);
        this.shape = new JToggleButton();
        this.shape.setEnabled(true);
        this.shape.setToolTipText("Draw shapes on canvas");
        paintcan = new JToggleButton();
        paintcan.setToolTipText("Change canvas background");
        this.paintcan.setEnabled(true);
        undo = new JButton();
        undo.setToolTipText("Undo last change to canvas");
        undo.setEnabled(false);
        redo = new JButton();
        redo.setToolTipText("Redo last change to canvas");
        redo.setEnabled(false);
        this.pencil.setSelected(true);

        pencil.addActionListener(this);
        eraser.addActionListener(this);
        font.addActionListener(this);
        highlighter.addActionListener(this);
        shape.addActionListener(this);
        paintcan.addActionListener(this);
        undo.addActionListener(this);
        redo.addActionListener(this);

        // add to button group
        bg.add(pencil);
        bg.add(highlighter);
        bg.add(eraser);
        bg.add(font);
        bg.add(shape);
        bg.add(paintcan);
        bg.add(undo);
        bg.add(redo);

        // add components
        ribbon_inner_tools.add(pencil);
        ribbon_inner_tools.add(highlighter);
        ribbon_inner_tools.add(eraser);
        ribbon_inner_tools.add(font);
        ribbon_inner_tools.add(shape);
        ribbon_inner_tools.add(paintcan);
        ribbon_inner_tools.add(undo);
        ribbon_inner_tools.add(redo);

        this.add(ribbon_inner_tools, BorderLayout.CENTER);
        this.add(toolsLabel, BorderLayout.SOUTH);
    }

    private void prepareIcons() {
        FontIcon pencil_icon = FontIcon.of(FontAwesomeSolid.PAINT_BRUSH, Color.BLACK);
        FontIcon eraser_icon = FontIcon.of(FontAwesomeSolid.ERASER, Color.BLACK);
        FontIcon text_icon = FontIcon.of(FontAwesomeSolid.FONT, Color.BLACK);
        FontIcon highlighter_icon = FontIcon.of(FontAwesomeSolid.MAGIC, Color.BLACK);
        FontIcon shape_icon = FontIcon.of(FontAwesomeSolid.SQUARE, Color.BLACK);
        FontIcon paintcan_icon = FontIcon.of(FontAwesomeSolid.IMAGE, Color.BLACK);
        FontIcon undo_icon = FontIcon.of(FontAwesomeSolid.UNDO, Color.BLACK);
        FontIcon redo_icon = FontIcon.of(FontAwesomeSolid.REDO, Color.BLACK);

        pencil.setIcon(pencil_icon);
        eraser.setIcon(eraser_icon);
        font.setIcon(text_icon);
        highlighter.setIcon(highlighter_icon);
        paintcan.setIcon(paintcan_icon);
        shape.setIcon(shape_icon);
        undo.setIcon(undo_icon);
        redo.setIcon(redo_icon);

    }

    public void enableRedo() {
        this.redo.setEnabled(true);
        return;
    }

    public void enableUndo() {
        this.undo.setEnabled(true);
        return;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pencil ) {
            MainFrame.canvas.setCurrentTool(Tool.PENCIL);
        } else if(e.getSource() == eraser) {
            MainFrame.canvas.setCurrentTool(Tool.ERASER);
        } else if(e.getSource() == font) {
            MainFrame.canvas.setCurrentTool(Tool.FONT);
        } else if(e.getSource() == highlighter) {
            MainFrame.canvas.setCurrentTool(Tool.HIGHLIGHTER);
        } else if(e.getSource() == shape) {
            MainFrame.canvas.setCurrentTool(Tool.RECTANGLE);
        } else if(e.getSource() == paintcan) {
            MainFrame.canvas.setCurrentTool(Tool.PAINTCAN);
        } else if (e.getSource() == undo) {
            MainFrame.canvas.undo();
        } else if (e.getSource() == redo) {
            MainFrame.canvas.redo();
        }   
	}

	public void disableUndo() {
        this.undo.setEnabled(false);
	}

	public void disableRedo() {
        this.redo.setEnabled(false);
	}

}