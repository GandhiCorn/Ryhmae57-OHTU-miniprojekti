package ryhma57.references;

import java.util.EnumSet;
import ryhma57.backend.BibtexReferenceField;
import static ryhma57.backend.BibtexReferenceField.*;

/**
 *
 * @author Simo
 */
public class Inproceedings extends Reference {

    private static EnumSet<BibtexReferenceField> existingFields;
    private static EnumSet<BibtexReferenceField> requiredFields, optionalFields;

    static {
        Inproceedings.requiredFields = Reference.createFieldSet(AUTHOR,
                TITLE, BOOKTITLE, YEAR);
        Inproceedings.optionalFields = Reference.createFieldSet(EDITOR, 
                VOLUME, SERIES, PAGES, ADDRESS, MONTH, ORGANIZATION,
                PUBLISHER, NOTE);
        Inproceedings.existingFields = Reference.createExistingSet(Inproceedings.requiredFields, Inproceedings.optionalFields);
    }

    public Inproceedings() {
        super(existingFields, requiredFields, "inproceedings");
    }
}
