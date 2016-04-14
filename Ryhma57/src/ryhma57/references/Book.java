package ryhma57.references;

import java.util.EnumSet;
import ryhma57.backend.BibtexReferenceField;
import static ryhma57.backend.BibtexReferenceField.*;

public class Book extends Reference {
    private static EnumSet<BibtexReferenceField> existingFields;
    private static EnumSet<BibtexReferenceField> requiredFields;

    static {
        EnumSet<BibtexReferenceField> optionals;
        Book.requiredFields = Reference.createFieldSet(ID,
                AUTHOR, TITLE, YEAR, PUBLISHER);
        optionals = Reference.createFieldSet(VOLUME,
                NUMBER, SERIES, ADDRESS, EDITION, MONTH, NOTE);

        Book.existingFields = Reference.createExistingSet(
                Book.requiredFields, optionals);
    }

    public Book(String id, String author, String title, String year, String publisher) {
        super(existingFields, requiredFields);
        setField(ID, id);
        setField(AUTHOR, author);
        setField(TITLE, title);
        setField(YEAR, year);
        setField(PUBLISHER, publisher);
    }
    
    public String toBibTex() {
        return "@book{" + getField(ID) + ",\n" +
                "author = {" + getField(ID) + "},\n" +
                "title = {" + getField(TITLE) + "},\n" +
                "year = {" + getField(YEAR) + "},\n" +
                "publisher = {" + getField(PUBLISHER) + "},\n" + "}";
    }
}
