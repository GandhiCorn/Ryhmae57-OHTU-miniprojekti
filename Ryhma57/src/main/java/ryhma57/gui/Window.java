package ryhma57.gui;

import java.awt.*;
import java.awt.event.*;

import java.util.EnumMap;
import javax.swing.*;
import ryhma57.backend.BibtexReferenceField;

public class Window extends JFrame implements ActionListener {

    static final String CREATE = "create";
    static final String GENERATE = "generate";
    static final String CLEAR_LABEL = "clearLabel";
    static final String DROPDOWN = "dropdown";
    
    private Application app;
    private JLabel infoLabel;
    
    private String[] referenceTypes = {"Book", "Inproceedings", "Article"};

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
        JPanel mainPane = new FieldsForm(this.app);
        this.add(mainPane, BorderLayout.NORTH);

        button = new JButton("Generate BibTeX file");
        button.addActionListener(this);
        button.setActionCommand(GENERATE);

        this.infoLabel = new JLabel("");
        this.add(this.infoLabel, BorderLayout.CENTER);

        this.add(button, BorderLayout.SOUTH);
        
        JComboBox referenceList = new JComboBox(referenceTypes);
        referenceList.addActionListener(this);
        referenceList.setActionCommand(DROPDOWN);
        mainPane.add(referenceList, BorderLayout.NORTH);
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
            
        // Tässä pystyy käsittelemään drodownin actionia esim vaihtamaan talletustyypin eri referenssien välillä
        } else if (event.getActionCommand().equals(DROPDOWN)) {
            
        }
        
    }
}
