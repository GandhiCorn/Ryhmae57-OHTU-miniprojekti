package ryhma57.references;

import java.io.Serializable;
import java.util.EnumSet;
import ryhma57.backend.BibtexReferenceField;
import static ryhma57.backend.BibtexReferenceField.*;

public class Book extends Reference implements Serializable {
    private static EnumSet<BibtexReferenceField> existingFields;
    private static EnumSet<BibtexReferenceField> requiredFields, optionalFields;

    static {
        Book.requiredFields = Reference.createFieldSet(ID, AUTHOR,
                EDITOR, TITLE, YEAR, PUBLISHER);
        Book.optionalFields = Reference.createFieldSet(VOLUME,
                NUMBER, SERIES, ADDRESS, EDITION, MONTH, NOTE, TAGS);
        Book.existingFields = Reference.createExistingSet(
                Book.requiredFields, Book.optionalFields);
    }

    public Book() {
        super(existingFields, requiredFields, "book");
    }
    
    public EnumSet<BibtexReferenceField> getExistingFields() {
        return existingFields;
    }

    public EnumSet<BibtexReferenceField> getRequiredFields() {
        return requiredFields;
    }
}
