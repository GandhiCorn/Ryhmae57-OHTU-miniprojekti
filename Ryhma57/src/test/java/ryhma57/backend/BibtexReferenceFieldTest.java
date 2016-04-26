package ryhma57.backend;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BibtexReferenceFieldTest {
    
    public BibtexReferenceFieldTest() {
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
    public void testValuesContainsID() {
        BibtexReferenceField id = BibtexReferenceField.valueOf("ID");
        assertEquals(BibtexReferenceField.ID, id);
    }

    @Test
    public void testValueOf() {
        String name = "AUTHOR";
        BibtexReferenceField expResult = BibtexReferenceField.AUTHOR;
        BibtexReferenceField result = BibtexReferenceField.valueOf(name);
        assertEquals(expResult, result);
        
        String name2 = "YEAR";
        BibtexReferenceField expResult2 = BibtexReferenceField.YEAR;
        BibtexReferenceField result2 = BibtexReferenceField.valueOf(name2);
        assertEquals(expResult2, result2);
    }

    @Test
    public void testGetName() {
        BibtexReferenceField field = BibtexReferenceField.AUTHOR;
        String fieldName = field.getName();
        assertEquals(fieldName, "author");
    }
    
}
