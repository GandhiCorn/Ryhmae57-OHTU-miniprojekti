package ryhma57.gui;

import java.awt.*;
import java.awt.event.*;

import java.util.EnumMap;
import javax.swing.*;
import ryhma57.backend.BibtexReferenceField;

public class Window extends JFrame implements ActionListener {

    static final String GENERATE = "generate";
    static final String CLEAR_LABEL = "clearLabel";
    
    private Application app;
    private JLabel infoLabel;

    public Window(Application app) {
        this.app = app;
        this.setTitle("Application");
        /* set some default size so that window isn't 0x0 size */
        /*XXX we could load window geometry from config file */
        this.setSize(600, 480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.createComponents();
    }

    private void createComponents() {
        JButton button;
        JScrollPane scrollPane;
        JPanel pane, aligner;
        pane = new FieldsForm(this.app);
        this.add(pane, BorderLayout.NORTH);

        pane = new ListView(this.app);
        aligner = new JPanel();
        aligner.setLayout(new BorderLayout());
        aligner.add(pane, BorderLayout.PAGE_START);
        scrollPane = new JScrollPane(aligner);
        this.add(scrollPane, BorderLayout.CENTER);

        this.infoLabel = new JLabel("");
        this.add(this.infoLabel, BorderLayout.SOUTH);

        button = new JButton("Generate BibTeX file");
        button.addActionListener(this);
        button.setActionCommand(GENERATE);

        this.add(button, BorderLayout.WEST);
        
    }

    public void setErrorMessage(String error) {
        Timer timer;

        this.infoLabel.setText("The reference was saved");
        timer = new Timer(10000, this);
        timer.start();
        timer.setActionCommand(CLEAR_LABEL);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals(GENERATE)) {
            this.app.generateBibTex();
            JOptionPane.showMessageDialog(this,
                    "BibTex file was generated.");
        } else if (event.getActionCommand().equals(CLEAR_LABEL)) {
            this.infoLabel.setText("");
        }
        
    }
}
