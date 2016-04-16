package ryhma57.references;

import java.util.EnumSet;
import ryhma57.backend.BibtexReferenceField;
import static ryhma57.backend.BibtexReferenceField.*;

public class Book extends Reference {
    private static EnumSet<BibtexReferenceField> existingFields;
    private static EnumSet<BibtexReferenceField> requiredFields, optionalFields;

    static {
        Book.requiredFields = Reference.createFieldSet(AUTHOR,
                EDITOR, TITLE, YEAR, PUBLISHER);
        Book.optionalFields = Reference.createFieldSet(VOLUME,
                NUMBER, SERIES, ADDRESS, EDITION, MONTH, NOTE);
        Book.existingFields = Reference.createExistingSet(
                Book.requiredFields, Book.optionalFields);
    }

    public Book() {
        super(existingFields, requiredFields, "book");
    }
}
