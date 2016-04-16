package ryhma57.backend;

import ryhma57.references.Book;
import ryhma57.references.Reference;
import static ryhma57.backend.BibtexReferenceField.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReferenceListTest {
    
    private ReferenceList list;
    private Reference r1;
    private Reference r2;
    private Reference r3;
    
    public ReferenceListTest() {
        r1 = new Book();
        r1.setID("ID1");
        r1.setField(AUTHOR, "Author1");
        r1.setField(TITLE, "Title1");
        r1.setField(YEAR, "Year1");
        r1.setField(PUBLISHER, "Publisher1");

        r2 = new Book();
        r2.setID("ID2");
        r2.setField(AUTHOR, "Author2");
        r2.setField(TITLE, "Title2");
        r2.setField(YEAR, "Year2");
        r2.setField(PUBLISHER, "Publisher2");

        r3 = new Book();
        r3.setID("ID3");
        r3.setField(AUTHOR, "Author3");
        r3.setField(TITLE, "Title3");
        r3.setField(YEAR, "Year3");
        r3.setField(PUBLISHER, "Publisher3");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        list = new ReferenceList();
    }
    
    @After
    public void tearDown() {
        list = null;
    }

    @Test
    public void testAddReference() {
        list.addReference(r1);
        assertEquals(list.get(0), r1);
    }
    
    @Test
    public void cantAddNullReference() {
        list.addReference(null);
        assertEquals(list.size(), 0);
    }

    @Test
    public void testGetAll() {
        list.addReference(r1);
        list.addReference(r2);
        list.addReference(r3);
        List<Reference> list2 = list.getAll();
        assertEquals(list2.size(), 3);
        assertEquals(list2.get(0), r1);
        assertEquals(list2.get(1), r2);
        assertEquals(list2.get(2), r3);        
    }

    @Test
    public void testGet() {
        list.addReference(r1);
        assertEquals(list.get(0), r1);
    }

    @Test
    public void testSize() {
        assertEquals(list.size(), 0);
        list.addReference(r1);
        assertEquals(list.size(), 1);
    }
}
