package ryhma57.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ryhma57.backend.BibtexReferenceField;

public class FieldsForm extends JPanel implements ActionListener {
    private EnumMap<BibtexReferenceField, JFormattedTextField> fields;
    private static String SAVE = "save";
    static final String DROPDOWN = "dropdown";
    private Application app;

    private String[] referenceTypes = {"Book", "Inproceedings", "Article"};

    public FieldsForm(Application app) {
        super(new BorderLayout());
        this.app = app;
        this.fields = new EnumMap<>(BibtexReferenceField.class);
        createComponents();
    }

    private void generateField(JPanel labelPane, JPanel inputPane, BibtexReferenceField field) {
        JFormattedTextField input;

        labelPane.add(new JLabel(field.getName() + ":"));
        input = new JFormattedTextField();
        input.setColumns(10);
        this.fields.put(field, input);
        inputPane.add(input);
    }

    final public void createComponents() {
        JPanel labelPane = new JPanel(new GridLayout(0, 1));
        JPanel inputPane = new JPanel(new GridLayout(0, 1));

        JComboBox referenceList = new JComboBox(referenceTypes);
        referenceList.addActionListener(this);
        referenceList.setActionCommand(DROPDOWN);
        this.add(referenceList, BorderLayout.NORTH);

        this.setBorder(BorderFactory.createTitledBorder("Create a reference"));

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

        this.add(labelPane, BorderLayout.CENTER);
        this.add(inputPane, BorderLayout.LINE_END);

        JButton button;
        button = new JButton("Save");
        button.addActionListener(this);
        button.setActionCommand(SAVE);
        this.add(button, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals(SAVE)) {
            EnumMap<BibtexReferenceField, String> set;
            set = new EnumMap<>(BibtexReferenceField.class);

            for (BibtexReferenceField field : this.fields.keySet()) {
                JFormattedTextField input;
                input = this.fields.get(field);
                set.put(field, input.getText());
            }

            this.app.createNewBookReference(set);
        // Tässä pystyy käsittelemään drodownin actionia esim vaihtamaan talletustyypin eri referenssien välillä
        } else if (event.getActionCommand().equals(DROPDOWN)) {
        }
    }
}
