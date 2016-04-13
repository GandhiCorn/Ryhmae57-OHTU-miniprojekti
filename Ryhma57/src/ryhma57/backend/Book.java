package ryhma57.backend;

import java.util.EnumSet;
import static ryhma57.backend.BibtexReferenceField.*;

public class Book extends Reference {
    static EnumSet<BibtexReferenceField> existingFields;
    static EnumSet<BibtexReferenceField> requiredFields;

    static {
        Book.requiredFields = EnumSet.noneOf(BibtexReferenceField.class);
        Book.requiredFields.add(ID);
        Book.requiredFields.add(AUTHOR);
        Book.requiredFields.add(TITLE);
        Book.requiredFields.add(YEAR);
        Book.requiredFields.add(PUBLISHER);
        Book.existingFields = Book.requiredFields.clone();
        
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
