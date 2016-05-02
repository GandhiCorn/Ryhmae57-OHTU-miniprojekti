package ryhma57.backend;

/* Every possible field of a reference.
 *
 * These are directly from the bibtex documentation.
 * http://get-software.net/biblio/bibtex/base/btxdoc.pdf
 */
public enum BibtexReferenceField {
    /* The id field should only be used in gui. */
    ID("id"),

    ADDRESS("address"),
    ANNOTE("annote"),
    AUTHOR("author"),
    BOOKTITLE("booktitle"),
    CHAPTER("chapter"),
    CROSSREF("crossref"),
    EDITION("edition"),
    EDITOR("editor"),
    HOWPUBLISHED("howpublished"),
    INSTITUTION("institution"),
    JOURNAL("journal"),
    KEY("key"),
    MONTH("month"),
    NOTE("note"),
    NUMBER("number"),
    ORGANIZATION("organization"),
    PAGES("pages"),
    PUBLISHER("publisher"),
    SCHOOL("school"),
    SERIES("series"),
    TITLE("title"),
    TYPE("type"),
    VOLUME("volume"),
    YEAR("year"),
    TAG("tag");

    private final String name;

    BibtexReferenceField(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
