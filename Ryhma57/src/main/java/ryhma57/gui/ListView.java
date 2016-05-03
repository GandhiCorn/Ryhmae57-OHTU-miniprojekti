package ryhma57.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 * This component will contain the references. It is currently under
 * construction.
 */
public class ListView extends JPanel implements MouseListener, ActionListener {

    private final Application app;
    private int length;
    private JLabel placeholder;
    private int selectedRow;
    private JPopupMenu popup;
    private JMenuItem menuItem;

    public ListView(Application app) {
        this.app = app;
        this.length = 0;
        this.setLayout(new GridBagLayout());
        this.addMouseListener(this);

        addPlaceHolder();
    }

    public final void addPlaceHolder() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.weightx = c.weighty = 1.0;
        c.ipadx = c.ipady = 10;
        c.anchor = GridBagConstraints.CENTER;

        this.placeholder = new JLabel("No references");
        this.add(this.placeholder, c);
        this.revalidate();
    }

    public void createRow(String id, String name) {
        createRow(id, name, null);
    }

    public void createRow(String id, String name, List<String> tags) {
        GridBagConstraints c = new GridBagConstraints();
        String tagStr = " ";

        if(tags != null && tags.size() > 0) {
            tagStr = String.join("] [", tags);
            tagStr = "[" + tagStr + "]";
        }

        /* Remove the placeholder */
        if (this.placeholder.getParent() == this) {
            this.remove(this.placeholder);
        }

        /* id column */
        JLabel idLabel = new JLabel(id);
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = this.length++;
        c.gridwidth = 1;
        c.weightx = c.weighty = 0.0;
        c.ipadx = c.ipady = 10;
        c.anchor = GridBagConstraints.WEST;
        this.add(idLabel, c);

        /* name column */
        JLabel nameLabel = new JLabel(name);
        c.gridx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.weightx = 1.0;
        this.add(nameLabel, c);

        /* tags column */
        JLabel tagLabel = new JLabel(tagStr);
        c.gridx = 4;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.weightx = 0.0;
        c.anchor = GridBagConstraints.EAST;
        this.add(tagLabel, c);
        this.revalidate();
    }

    /* remove all rows and add the placeholder */
    public void clear() {
        for (Component c : this.getComponents()) {
            this.remove(c);
        }
        this.addPlaceHolder();
        this.validate();
        this.repaint();
    }

    private void renderRow() {
        GridBagLayout layout = (GridBagLayout) this.getLayout();
        for (Component c : this.getComponents()) {
            GridBagConstraints cosntraints;
            JLabel label = (JLabel) c;

            cosntraints = layout.getConstraints(c);
            if (cosntraints.gridy == this.selectedRow) {
                label.setForeground(Color.black);
                label.setBackground(Color.lightGray);
                label.setOpaque(true);
            } else {
                label.setBackground(Color.white);
                label.setOpaque(false);
            }
        }
    }

    public void removeRow(int index) {
        GridBagLayout layout = (GridBagLayout) this.getLayout();
        for (Component c : this.getComponents()) {
            GridBagConstraints constraints;

            constraints = layout.getConstraints(c);
            if (constraints.gridy == index) {
                this.remove(c);
            } else if (constraints.gridy > index) {
                constraints.gridy--;
                layout.setConstraints(c, constraints);
            }
        }
        if (this.getComponents().length == 0) {
            this.addPlaceHolder();
        }
        this.validate();
        this.repaint();
    }

    private void selectItemAt(Point cursor) {
        GridBagLayout layout = (GridBagLayout) this.getLayout();

        for (Component c : this.getComponents()) {
            GridBagConstraints constraints;

            constraints = layout.getConstraints(c);

            Point p = new Point(cursor);
            p.x -= c.getX();
            p.y -= c.getY();
            if (c.contains(p)) {
                this.selectedRow = constraints.gridy;
                //this.columnSelected = cosntraints.gridx
            }
        }
        renderRow();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        selectItemAt(e.getPoint());

        if (e.getButton() == MouseEvent.BUTTON3) {
            popup = new JPopupMenu();
            menuItem = new JMenuItem("Delete");
            menuItem.addActionListener(this);
            popup.add(menuItem);
            popup.show(e.getComponent(), e.getX(), e.getY());
        }        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.app.removeReference(this.selectedRow);
    }
}
