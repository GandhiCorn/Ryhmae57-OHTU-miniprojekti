package ryhma57.backend;

/* Every possible field of a reference.
 *
 * These are directly from the bibtex documentation.
 * http://get-software.net/biblio/bibtex/base/btxdoc.pdf
 */
public enum ReferenceType {
    ARTICLE("Article"),
    BOOK("Book"),
    INPROCEEDINGS("Inproceedings");

    private final String name;

    ReferenceType(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
