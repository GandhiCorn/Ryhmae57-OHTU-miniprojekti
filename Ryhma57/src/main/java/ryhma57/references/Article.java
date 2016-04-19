package ryhma57.references;

import java.util.EnumSet;
import ryhma57.backend.BibtexReferenceField;
import static ryhma57.backend.BibtexReferenceField.*;

public class Article extends Reference {
    private static EnumSet<BibtexReferenceField> existingFields;
    private static EnumSet<BibtexReferenceField> requiredFields, optionalFields;

    static {
        Article.requiredFields = Reference.createFieldSet(AUTHOR,
                TITLE, JOURNAL, YEAR);
        Article.optionalFields = Reference.createFieldSet(VOLUME,
                SERIES, ADDRESS, EDITION, MONTH, NOTE);
        Article.existingFields = Reference.createExistingSet(
                Article.requiredFields, Article.optionalFields);
    }

    public Article() {
        super(existingFields, requiredFields, "article");
    }
}
