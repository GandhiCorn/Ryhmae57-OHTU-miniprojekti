package ryhma57.references;

import java.util.EnumSet;
import static ryhma57.backend.BibtexReferenceField.*;

public class Book extends Reference {

    public Book() {
        super(
                EnumSet.of(ID, AUTHOR, EDITOR, TITLE, YEAR, PUBLISHER),
                EnumSet.of(VOLUME, NUMBER, SERIES, ADDRESS, EDITION, MONTH, NOTE),
                "book"
        );
    }
}
