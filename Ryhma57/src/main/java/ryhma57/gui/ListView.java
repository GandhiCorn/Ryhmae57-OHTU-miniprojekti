package ryhma57.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This component will contain the references.
 * It is currently under construction.
 */
public class ListView extends JPanel implements MouseListener {
    private final Application app;
    private int length;
    private JLabel placeholder;
    private int selectedRow;

    public ListView(Application app) {
        this.app = app;
        this.length = 0;
        this.setLayout(new GridBagLayout());
        this.addMouseListener(this);

        createPlaceHolder();
    }

    public final void createPlaceHolder() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = this.length++;
        c.gridwidth = 2;
        c.weightx = c.weighty = 1.0;
        c.ipadx = c.ipady = 10;
        c.anchor = GridBagConstraints.CENTER;

        this.placeholder = new JLabel("No references created");
        this.add(this.placeholder, c);
        this.revalidate();
    }

    public void createRow(String id, String name) {
        GridBagConstraints c = new GridBagConstraints();

        /* Remove the placeholder */
        if(this.placeholder.getParent() == this) {
            this.remove(this.placeholder);
        }

        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = this.length++;
        c.gridwidth = 1;
        c.weightx = c.weighty = 0.0;
        c.ipadx = c.ipady = 10;
        c.anchor = GridBagConstraints.WEST;

        JLabel idLabel = new JLabel(id);
        JLabel nameLabel = new JLabel(name);
        this.add(idLabel, c);
        c.gridx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.weightx = 1.0;
        this.add(nameLabel, c);
        this.revalidate();
    }

    private void renderRow() {
        GridBagLayout layout = (GridBagLayout)this.getLayout();
        for (Component c : this.getComponents()) {
            GridBagConstraints cosntraints;
            JLabel label = (JLabel)c;

            cosntraints = layout.getConstraints(c);
            if(cosntraints.gridy == this.selectedRow) {
                label.setForeground(Color.black);
                label.setBackground(Color.lightGray);
                label.setOpaque(true);
            } else {
                label.setBackground(Color.white);
                label.setOpaque(false);
            }
        }
    }
    private void selectItemAt(Point cursor) {
        GridBagLayout layout = (GridBagLayout)this.getLayout();

        for (Component c : this.getComponents()) {
            GridBagConstraints cosntraints;

            cosntraints = layout.getConstraints(c);

            Point p = new Point(cursor);
            p.x -= c.getX();
            p.y -= c.getY();
            if(c.contains(p)) {
                this.selectedRow = cosntraints.gridy;
                //cosntraints.gridx
            }
        }
        renderRow();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        selectItemAt(e.getPoint());
        /* here check if right button was clicked and create context menu */
        //this.selectedRow tells the index of the selected reference
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
