package ryhma57.gui;
import java.awt.*;
import java.awt.event.*;

import java.util.EnumMap;
import javax.swing.*;
import ryhma57.backend.BibtexReferenceField;

public class Window extends JFrame implements ActionListener {
    static final String CREATE = "create";
    static final String GENERATE = "generate";
    private Application app;

    /* this is bit ugly */
    private EnumMap<BibtexReferenceField, JFormattedTextField> fields;

    public Window(Application app) {
        this.app = app;
        this.setTitle("Application");
        /* set some default size so that window isn't 0x0 size */
        /*XXX we could load window geometry from config file */
        this.setSize(600, 480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.fields = new EnumMap<>(BibtexReferenceField.class);
        this.createDialog();
    }

    private void generateField(JPanel labelPane, JPanel inputPane, BibtexReferenceField field) {
        JFormattedTextField input;

        labelPane.add(new JLabel(field.getName() + ":"));
        input = new JFormattedTextField();
        input.setColumns(10);
        this.fields.put(field, input);
        inputPane.add(input);
    }

    private void createDialog() {
        JFormattedTextField input;
        JPanel mainPane = new JPanel(new BorderLayout());
        JPanel labelPane = new JPanel(new GridLayout(0,1));
        JPanel inputPane = new JPanel(new GridLayout(0,1));

        mainPane.setBorder(BorderFactory.createTitledBorder("Create book reference"));

        generateField(labelPane, inputPane, BibtexReferenceField.ID);
        generateField(labelPane, inputPane, BibtexReferenceField.AUTHOR);
        generateField(labelPane, inputPane, BibtexReferenceField.EDITOR);
        generateField(labelPane, inputPane, BibtexReferenceField.TITLE);
        generateField(labelPane, inputPane, BibtexReferenceField.PUBLISHER);
        generateField(labelPane, inputPane, BibtexReferenceField.YEAR);

        generateField(labelPane, inputPane, BibtexReferenceField.VOLUME);
        generateField(labelPane, inputPane, BibtexReferenceField.NUMBER);
        generateField(labelPane, inputPane, BibtexReferenceField.SERIES);
        generateField(labelPane, inputPane, BibtexReferenceField.ADDRESS);
        generateField(labelPane, inputPane, BibtexReferenceField.EDITION);
        generateField(labelPane, inputPane, BibtexReferenceField.MONTH);
        generateField(labelPane, inputPane, BibtexReferenceField.NOTE);


        mainPane.add(labelPane, BorderLayout.CENTER);
        mainPane.add(inputPane, BorderLayout.LINE_END);
        this.add(mainPane, BorderLayout.NORTH);

        JButton button;
        button = new JButton("Save");
        button.addActionListener(this);
        button.setActionCommand(CREATE);
        mainPane.add(button, BorderLayout.SOUTH);

        button = new JButton("Generate BibTeX file");
        button.addActionListener(this);
        button.setActionCommand(GENERATE);
        this.add(button, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getActionCommand().equals(CREATE)) {
            EnumMap<BibtexReferenceField, String> set;
            set = new EnumMap<>(BibtexReferenceField.class);

            for(BibtexReferenceField field : this.fields.keySet()) {
                JFormattedTextField input;
                input = this.fields.get(field);
                set.put(field, input.getText());
            }
            this.app.createNewBookReference(set);

        } else if(event.getActionCommand().equals(GENERATE)) {
            this.app.generateBibTex();
            JOptionPane.showMessageDialog(this,
                "BibTex file was generated.");
        }
    }
}
