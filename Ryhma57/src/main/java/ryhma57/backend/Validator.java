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
        BibtexReferenceField invalidField = checkFields(reference);
        if (invalidField != null) {
            return "Invalid or required field: " + invalidField.getName();
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
            if (reference.getField(field) == null || reference.getField(field).equals("")) {
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
