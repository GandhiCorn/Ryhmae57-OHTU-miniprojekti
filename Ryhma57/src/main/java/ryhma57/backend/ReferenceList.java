package ryhma57.backend;

import java.io.Serializable;
import ryhma57.references.Reference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReferenceList implements Serializable {
    private static final long serialVersionUID = 2504774830084138204l;
    
    private List<Reference> list;
    private HashSet<String> ids;
    
    public ReferenceList() {
        this.list = new ArrayList<>();
        this.ids = new HashSet<>();
    }
    
    public int size() {
        return list.size();
    }
    
    public void addReference(Reference r) {
        if(r != null) {
            list.add(r);
            ids.add(r.getField(BibtexReferenceField.ID));
        }
    }
    
    public void deleteReference(Reference reference) {
        list.remove(reference);
    }
    
    public Reference get(int index) {
        return list.get(index);
    }
    
    public List<Reference> getAll() {
        return list;
    }
    
    public String toBibTex() {
        StringBuilder sb = new StringBuilder();
        for (Reference r : list) {
            sb.append(r.toBibTex()).append("\n");
        }
        return sb.toString();
    }
    
    public boolean checkDuplicateId(String id) {
        return this.ids.contains(id);
    }
    
    
    public List<Reference> search(String word) {
        List<Reference> searchList = new ArrayList<Reference>() {};
        for (Reference r : list) {
            for (BibtexReferenceField f : r.getExistingFields()) {
                if (r.getField(f) != null && r.getField(f).contains(word)) {
                    searchList.add(r);
                    break;
                }
            }
        }
        return searchList;
    }
    
    /* Metodi pelkkien kirjaolioiden saamiseksi
    */
//    public List<Book> getBooks() {
//        Book[] a = (Book[]) list.stream().filter(b -> b.getClass().equals(Book.class)).toArray();
//        return Arrays.asList(a);
//    }
}
