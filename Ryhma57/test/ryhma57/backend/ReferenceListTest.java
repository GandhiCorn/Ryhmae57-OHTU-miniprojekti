
package ryhma57.backend;

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
        r1 = new Book("ID1", "Author1", "Title1", "Year1", "Publisher1");
        r2 = new Book("ID2", "Author2", "Title2", "Year2", "Publisher2");
        r3 = new Book("ID3", "Author3", "Title3", "Year3", "Publisher3");
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
    
//    @Test
//    public void testGetBooks() {
//        
//    }
}
