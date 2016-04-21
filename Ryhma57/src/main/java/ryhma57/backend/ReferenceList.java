package ryhma57.backend;

import java.io.Serializable;
import ryhma57.references.Reference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReferenceList implements Serializable {
    
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
        for (Reference r : list) {
            if (r.equals(reference)) {
                list.remove(r);
            }  
        }
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
    
    public boolean checkDuplicateId(Reference reference) {
        return this.ids.contains(reference.getField(BibtexReferenceField.ID));
    }
    
    /* Metodi pelkkien kirjaolioiden saamiseksi
    */
//    public List<Book> getBooks() {
//        Book[] a = (Book[]) list.stream().filter(b -> b.getClass().equals(Book.class)).toArray();
//        return Arrays.asList(a);
//    }
}
