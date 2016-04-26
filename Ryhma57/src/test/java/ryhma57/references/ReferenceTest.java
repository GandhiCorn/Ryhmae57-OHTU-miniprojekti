/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryhma57.references;

import java.util.EnumSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ryhma57.backend.BibtexReferenceField;
import static ryhma57.backend.BibtexReferenceField.AUTHOR;
import static ryhma57.backend.BibtexReferenceField.EDITOR;
import static ryhma57.backend.BibtexReferenceField.ID;
import static ryhma57.backend.BibtexReferenceField.PUBLISHER;
import static ryhma57.backend.BibtexReferenceField.TITLE;
import static ryhma57.backend.BibtexReferenceField.YEAR;
import ryhma57.backend.ReferenceType;

/**
 *
 * @author Simo
 */
public class ReferenceTest {
    
    public ReferenceTest() {
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

    

    public void testGetID() {
        
        Reference instance = new Book();
        instance.setField(ID, "3");
        String expResult = "3";
        String result = instance.getID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRequiredFields() {
        
        Reference instance = new Book();
        EnumSet<BibtexReferenceField> expResult = Reference.createFieldSet(ID, AUTHOR,
                EDITOR, TITLE, YEAR, PUBLISHER); ;
        EnumSet<BibtexReferenceField> result = instance.getRequiredFields();
        assertEquals(expResult, result);
       
    }
   
}
