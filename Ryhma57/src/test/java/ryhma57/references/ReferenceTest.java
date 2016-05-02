/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryhma57.references;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;
import static ryhma57.backend.BibtexReferenceField.*;
import ryhma57.backend.ReferenceType;

/**
 *
 * @author Simo
 */
public class ReferenceTest {

    Reference reference;

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
        reference = new Reference(ReferenceType.BOOK);
        reference.setField(ID, "ID1");
        reference.setField(AUTHOR, "Matti Nykänen");
        reference.setField(TITLE, "Kotkan lento");
        reference.setField(YEAR, "2002");
        reference.setField(PUBLISHER, "Otava");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetID() {
        reference.setField(ID, "3");
        String expResult = "3";
        String result = reference.getID();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetField() {
        reference.setField(AUTHOR, "Janne Ahonen");
        assertEquals(reference.getField(AUTHOR), "Janne Ahonen");
    }

    @Test
    public void testGetField() {
        assertEquals("Otava", reference.getField(PUBLISHER));
    }

    @Test
    public void testToBibTex() {
        String tuloste = reference.toBibTex();
        assertEquals(tuloste, "@book{ID1,\n"
                + "\tauthor = {Matti Nykänen},\n"
                + "\tpublisher = {Otava},\n"
                + "\ttitle = {Kotkan lento},\n"
                + "\tyear = {2002},\n"
                + "}");
    }
}
