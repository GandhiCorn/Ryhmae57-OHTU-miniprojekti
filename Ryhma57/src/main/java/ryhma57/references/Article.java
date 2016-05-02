package ryhma57.references;

import java.util.EnumSet;
import static ryhma57.backend.BibtexReferenceField.*;

public class Article extends ReferenceFields {

    public Article() {
        super(
                EnumSet.of(ID, AUTHOR, TITLE, JOURNAL, YEAR),
                EnumSet.of(VOLUME, SERIES, ADDRESS, EDITION, MONTH, NOTE)
        );
    }
}
