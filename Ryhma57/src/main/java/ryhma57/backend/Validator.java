package ryhma57.backend;

import ryhma57.references.Reference;

public class Validator {
    private ReferenceList list;
    
    public Validator() {
        list = new ReferenceList();
    }
    
    public void setReferenceList(ReferenceList list) {
        this.list = list;
    }

    public String validateReference(Reference reference) {
        if (checkFields(reference) != null) {
            return "Invalid or required field: " + checkFields(reference).getName();
        }
        if (list.checkDuplicateId(reference)) {
            return "Duplicate ID";
        }
        return null;
    }
    
    private BibtexReferenceField checkFields(Reference reference) {
        for (BibtexReferenceField field : reference.getRequiredFields()) {
            if (field == BibtexReferenceField.AUTHOR || field == BibtexReferenceField.EDITOR) {
                continue;
            }
            if (reference.getField(field).equals("") || reference.getField(field) == null) {
                return field;
            }
        }
        if (reference.getField(BibtexReferenceField.AUTHOR).equals("") && 
                reference.getField(BibtexReferenceField.EDITOR).equals("")) {
            return BibtexReferenceField.AUTHOR;
        }
        return null;
    }
    
}
