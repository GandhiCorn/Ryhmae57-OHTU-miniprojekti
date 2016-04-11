package ryhma57.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReferenceList {
    
    private List<Reference> list;
    
    public ReferenceList() {
        this.list = new ArrayList<>();
    }
    
    public int size() {
        return list.size();
    }
    
    public void addReference(Reference r) {
        if(r != null) {
            list.add(r);
        }
    }
    
    public Reference get(int index) {
        return list.get(index);
    }
    
    public List<Reference> getAll() {
        return list;
    }
    
    public void toBibtex() {
        for (Reference r : list) {
            r.toBibTex();
        }
    }
    
    /* Metodi pelkkien kirjaolioiden saamiseksi
    */
//    public List<Book> getBooks() {
//        Book[] a = (Book[]) list.stream().filter(b -> b.getClass().equals(Book.class)).toArray();
//        return Arrays.asList(a);
//    }
}
