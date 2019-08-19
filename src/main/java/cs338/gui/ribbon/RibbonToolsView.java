package cs338.gui.ribbon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import cs338.gui.canvas.Tool;
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
    JToggleButton pencil, magnify, eraser, font, dropper, paintcan;
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

        // labels
        JLabel toolsLabel = new JLabel("Tools", SwingConstants.CENTER);

        // buttongroup
        this.bg = new ButtonGroup();

        // buttons
        pencil = new JToggleButton();
        eraser = new JToggleButton();
        font = new JToggleButton();
        magnify = new JToggleButton();
        dropper = new JToggleButton();
        paintcan = new JToggleButton("C");
        undo = new JButton();
        undo.setEnabled(false);
        redo = new JButton();
        redo.setEnabled(false);
        this.pencil.setSelected(true);

        pencil.addActionListener(this);
        eraser.addActionListener(this);
        font.addActionListener(this);
        magnify.addActionListener(this);
        dropper.addActionListener(this);
        paintcan.addActionListener(this);
        undo.addActionListener(this);
        redo.addActionListener(this);

        // add to button group
        bg.add(pencil);
        bg.add(magnify);
        bg.add(eraser);
        bg.add(font);
        bg.add(dropper);
        bg.add(paintcan);
        bg.add(undo);
        bg.add(redo);

        // add components
        ribbon_inner_tools.add(pencil);
        ribbon_inner_tools.add(magnify);
        ribbon_inner_tools.add(eraser);
        ribbon_inner_tools.add(font);
        ribbon_inner_tools.add(dropper);
        ribbon_inner_tools.add(paintcan);
        ribbon_inner_tools.add(undo);
        ribbon_inner_tools.add(redo);

        this.add(ribbon_inner_tools, BorderLayout.CENTER);
        this.add(toolsLabel, BorderLayout.SOUTH);
    }

    private void prepareIcons() {
        FontIcon pencil_icon = FontIcon.of(FontAwesomeSolid.PENCIL_ALT, Color.BLACK);
        FontIcon eraser_icon = FontIcon.of(FontAwesomeSolid.ERASER, Color.BLACK);
        FontIcon text_icon = FontIcon.of(FontAwesomeSolid.FONT, Color.BLACK);
        FontIcon magnify_icon = FontIcon.of(FontAwesomeSolid.SEARCH_PLUS, Color.BLACK);
        FontIcon dropper_icon = FontIcon.of(FontAwesomeSolid.EYE_DROPPER, Color.BLACK);
        // FontIcon paintcan_icon = FontIcon.of(FontAwesomeSolid.FILL_DRIP, Color.BLACK);
        FontIcon undo_icon = FontIcon.of(FontAwesomeSolid.UNDO, Color.BLACK);
        FontIcon redo_icon = FontIcon.of(FontAwesomeSolid.REDO, Color.BLACK);

        pencil.setIcon(pencil_icon);
        eraser.setIcon(eraser_icon);
        font.setIcon(text_icon);
        magnify.setIcon(magnify_icon);
        dropper.setIcon(dropper_icon);
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
        } else if(e.getSource() == magnify) {
            
        } else if(e.getSource() == dropper) {
            
        } else if(e.getSource() == paintcan) {
            MainFrame.canvas.setCurrentTool(Tool.PAINTCAN);
        } else if (e.getSource() == undo) {
            
        } else if (e.getSource() == redo) {

        }
	}

}