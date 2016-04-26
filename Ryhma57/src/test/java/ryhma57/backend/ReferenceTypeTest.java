package ryhma57.backend;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ryhma57.references.*;

public class ReferenceTypeTest {
    
    public ReferenceTypeTest() {
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
    public void testValueOf() {
        String name = "ARTICLE";
        ReferenceType expResult = ReferenceType.ARTICLE;
        ReferenceType result = ReferenceType.valueOf(name);
        assertEquals(expResult, result);
        
        String name2 = "BOOK";
        ReferenceType expResult2 = ReferenceType.BOOK;
        ReferenceType result2 = ReferenceType.valueOf(name2);
        assertEquals(expResult2, result2);
        
        String name3 = "INPROCEEDINGS";
        ReferenceType expResult3 = ReferenceType.INPROCEEDINGS;
        ReferenceType result3 = ReferenceType.valueOf(name3);
        assertEquals(expResult3, result3);
    }

    @Test
    public void testToString() {
        ReferenceType instance = ReferenceType.ARTICLE;
        String expResult = "Article";
        String result = instance.toString();
        assertEquals(expResult, result);
        
        ReferenceType instance2 = ReferenceType.BOOK;
        String expResult2 = "Book";
        String result2 = instance2.toString();
        assertEquals(expResult2, result2);
        
        ReferenceType instance3 = ReferenceType.INPROCEEDINGS;
        String expResult3 = "Inproceedings";
        String result3 = instance3.toString();
        assertEquals(expResult3, result3);
    }

    @Test
    public void testGetReferenceClass() {
        ReferenceType instance = ReferenceType.ARTICLE;
        Class expResult = Article.class;
        Class result = instance.getReferenceClass();
        assertEquals(expResult, result);
        
        ReferenceType instance2 = ReferenceType.BOOK;
        Class expResult2 = Book.class;
        Class result2 = instance2.getReferenceClass();
        assertEquals(expResult2, result2);
        
        ReferenceType instance3 = ReferenceType.INPROCEEDINGS;
        Class expResult3 = Inproceedings.class;
        Class result3 = instance3.getReferenceClass();
        assertEquals(expResult3, result3);
    }
    
}
