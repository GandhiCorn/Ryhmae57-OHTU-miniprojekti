package ryhma57.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.EnumMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ryhma57.backend.BibtexReferenceField;
import ryhma57.backend.ReferenceType;
import static ryhma57.backend.ReferenceType.*;
import ryhma57.references.Reference;

public class FieldsForm extends JPanel implements ActionListener {

    private EnumMap<BibtexReferenceField, JLabel> fields;
    private static String SAVE = "save";
    static final String DROPDOWN = "dropdown";
    private Application app;
    private JComboBox referenceList;
    private JPanel inputPane, labelPane;

    private String[] referenceTypes = {"Book", "Inproceedings", "Article"};

    public FieldsForm(Application app) {
        super(new BorderLayout());
        this.app = app;
        this.fields = new EnumMap<>(BibtexReferenceField.class);
        createComponents();
    }

    private void generateField(JPanel labelPane, JPanel inputPane, BibtexReferenceField field) {
        JFormattedTextField input;
        
        JLabel label = new JLabel(field.getName() + ":");
        labelPane.add(label);
        input = new JFormattedTextField();
        input.setColumns(10);
        label.setLabelFor(input);
        this.fields.put(field, label);
        inputPane.add(input);
    }

    public void clearInputFields() {
        for (BibtexReferenceField field : this.fields.keySet()) {
            JFormattedTextField input;
            input = (JFormattedTextField) this.fields.get(field).getLabelFor();
            input.setValue("");
        }
    }

    final public void createComponents() {
        labelPane = new JPanel(new GridLayout(0, 1));
        inputPane = new JPanel(new GridLayout(0, 1));

        referenceList = new JComboBox(ReferenceType.values());
        referenceList.addActionListener(this);
        referenceList.setActionCommand(DROPDOWN);
        this.add(referenceList, BorderLayout.NORTH);

        this.setBorder(BorderFactory.createTitledBorder("Create a reference"));
        ReferenceType type = (ReferenceType) this.referenceList.getSelectedItem();
        generateFields(type);

        this.add(labelPane, BorderLayout.CENTER);
        this.add(inputPane, BorderLayout.LINE_END);

        JButton button;
        button = new JButton("Save");
        button.addActionListener(this);
        button.setActionCommand(SAVE);
        this.add(button, BorderLayout.SOUTH);
    }

    private void generateFields(ReferenceType type) {
        Reference dummy = null;
        for(JLabel oldLabel: this.fields.values()) {
            this.inputPane.remove(oldLabel.getLabelFor());
            this.labelPane.remove(oldLabel);
        }
        this.fields.clear();
        
        try {
            dummy = (Reference) type.getReferenceClass().newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(FieldsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (BibtexReferenceField field : dummy.getRequiredFields()) {
            generateField(labelPane, inputPane, field);
        }
        for (BibtexReferenceField field : dummy.getExistingFields()) {
            if(dummy.getRequiredFields().contains(field)) continue;
            generateField(labelPane, inputPane, field);
        }
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals(SAVE)) {
            EnumMap<BibtexReferenceField, String> set;
            set = new EnumMap<>(BibtexReferenceField.class);

            for (BibtexReferenceField field : this.fields.keySet()) {
                JFormattedTextField input;
                input = (JFormattedTextField) this.fields.get(field).getLabelFor();
                set.put(field, input.getText());
            }
            
            ReferenceType type = (ReferenceType) this.referenceList.getSelectedItem();
            this.app.createNewReference(type, set);
            clearInputFields();
            // Tässä pystyy käsittelemään drodownin actionia esim vaihtamaan talletustyypin eri referenssien välillä
        } else if (event.getActionCommand().equals(DROPDOWN)) {
            clearInputFields();
            ReferenceType type = (ReferenceType) this.referenceList.getSelectedItem();
            generateFields(type);

        }
    }
}
