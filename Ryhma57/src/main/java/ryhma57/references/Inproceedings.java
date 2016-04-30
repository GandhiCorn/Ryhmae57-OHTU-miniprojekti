package ryhma57.references;

import java.util.EnumSet;
import static ryhma57.backend.BibtexReferenceField.*;

/**
 *
 * @author Simo
 */
public class Inproceedings extends Reference {

    public Inproceedings() {
        super(
                EnumSet.of(ID, AUTHOR, TITLE, BOOKTITLE, YEAR),
                EnumSet.of(EDITOR, VOLUME, SERIES, PAGES, ADDRESS, MONTH,
                        ORGANIZATION, PUBLISHER, NOTE),
                "inproceedings"
        );
    }

}
