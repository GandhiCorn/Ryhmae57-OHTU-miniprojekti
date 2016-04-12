package ryhma57.backend;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Simo
 */
public class BookTest {
    
    private Book kirja;
    
    public BookTest() {
        kirja = new Book("ID1","Matti Nykänen", "Kotkan lento", "2002", "Otava");
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
    public void testSetField() {
        kirja.setField(BibtexReferenceField.AUTHOR, "Janne Ahonen");
        assertEquals(kirja.getField(BibtexReferenceField.AUTHOR), "Janne Ahonen");
    }
    
    @Test
    public void testSetNullField() {
        kirja.setField(BibtexReferenceField.ID, null);
        assertEquals(kirja.getField(BibtexReferenceField.ID), null);
    }
    
    
    @Test
    public void testGetField() {
        kirja.getField(BibtexReferenceField.ID);
        assertEquals(kirja.getField(BibtexReferenceField.ID), "ID1");
    }
    
    @Test
    public void testToBibTex() {
        String tuloste = kirja.toBibTex();
        assertEquals(tuloste, "@book{" + "ID1" + ",\n" + "author = {" + "Matti Nykänen" + "},\n" + "title = {" + "Kotkan lento" + "},\n" + "year = {" + "2002" + "},\n" + "publisher = {" + "Otava" + "},\n" + "}" );
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
