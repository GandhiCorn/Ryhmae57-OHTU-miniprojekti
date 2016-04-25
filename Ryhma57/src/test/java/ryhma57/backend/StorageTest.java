package ryhma57.backend;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static ryhma57.backend.BibtexReferenceField.AUTHOR;
import static ryhma57.backend.BibtexReferenceField.ID;
import static ryhma57.backend.BibtexReferenceField.PUBLISHER;
import static ryhma57.backend.BibtexReferenceField.TITLE;
import static ryhma57.backend.BibtexReferenceField.YEAR;
import ryhma57.references.Book;
import ryhma57.references.Reference;

public class StorageTest {
    
    private Storage storage;
    private Book book;
    
    public StorageTest() {
        storage = new Storage();
        book = new Book();
        book.setField(ID, "ID1");
	book.setField(AUTHOR, "Matti Nykänen");
	book.setField(TITLE, "Kotkan lento");
	book.setField(YEAR, "2002");
	book.setField(PUBLISHER, "Otava");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testStoringReference() {
        ReferenceList list = storage.getReferenceList();
        storage.storeNewReference(book);
        list.addReference(book);
        int i = 0;
        for (Reference ref : list.getAll()) {
            assertEquals(ref, storage.getReferenceList().get(i));
            i += 1;
        }
    }
    
    @Test
    public void testRemovingReference() {
        storage.storeNewReference(book);
        ReferenceList list = storage.getReferenceList();
        storage.removeReference(book);
        for (Reference ref : list.getAll()) {
            assertEquals(false, ref == book);
        }
    }
}
