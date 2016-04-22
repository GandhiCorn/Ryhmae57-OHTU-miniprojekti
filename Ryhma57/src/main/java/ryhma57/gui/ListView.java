package ryhma57.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * This component will contain the references.
 * It is currently under construction.
 */
public class ListView extends JPanel {
    private final Application app;
    private int length;
    private JLabel placeholder;

    public ListView(Application app) {
        this.app = app;
        this.length = 0;
        this.setLayout(new GridBagLayout());

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
}
