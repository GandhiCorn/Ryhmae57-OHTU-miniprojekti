package ryhma57.gui;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This component will contain the references.
 * It is currently under construction.
 */
public class ListView extends JPanel {
    private final Application app;

    public ListView(Application app) {
        JPanel row;

        this.app = app;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        row = new JPanel();
        row.setLayout(new BoxLayout(row, BoxLayout.LINE_AXIS));
        JLabel idLabel = new JLabel("id test");
        JLabel nameLabel = new JLabel("name test");
        row.add(idLabel);
        row.add(Box.createRigidArea(new Dimension(5,0)));
        row.add(nameLabel);
        this.add(row);

        row = new JPanel();
        row.setLayout(new BoxLayout(row, BoxLayout.LINE_AXIS));
        idLabel = new JLabel("id test");
        nameLabel = new JLabel("name test");
        row.add(idLabel);
        row.add(Box.createRigidArea(new Dimension(5,0)));
        row.add(nameLabel);
        this.add(row);

        row = new JPanel();
        row.setLayout(new BoxLayout(row, BoxLayout.LINE_AXIS));
        idLabel = new JLabel("id test");
        nameLabel = new JLabel("name test");
        row.add(idLabel);
        row.add(Box.createRigidArea(new Dimension(5,0)));
        row.add(nameLabel);
        this.add(row);
    }
}
