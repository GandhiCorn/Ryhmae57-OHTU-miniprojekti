package ryhma57.backend;

import ryhma57.references.*;

/* Every possible field of a reference.
 *
 * These are directly from the bibtex documentation.
 * http://get-software.net/biblio/bibtex/base/btxdoc.pdf
 */


public enum ReferenceType {
    ARTICLE("Article", Article.class),
    BOOK("Book", Book.class),
    INPROCEEDINGS("Inproceedings", Inproceedings.class);
    
    
    
    private final String name;
    private final Class referenceClass;
   ReferenceType(String name, Class referenceClass) {
       this.name = name;
       this.referenceClass = referenceClass;
       
   }
    public String toString() {
        return this.name;
    }
    public Class getReferenceClass() {
        return this.referenceClass;
    }
}
