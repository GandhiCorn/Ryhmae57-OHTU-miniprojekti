package ryhma57.backend;

import ryhma57.references.Book;
import static ryhma57.backend.BibtexReferenceField.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    private Book kirja;

    public BookTest() {
        kirja = new Book();
	kirja.setField(ID, "ID1");
	kirja.setField(AUTHOR, "Matti Nykänen");
	kirja.setField(TITLE, "Kotkan lento");
	kirja.setField(YEAR, "2002");
	kirja.setField(PUBLISHER, "Otava");
    }

    @Test
    public void testSetField() {
        kirja.setField(AUTHOR, "Janne Ahonen");
        assertEquals(kirja.getField(AUTHOR), "Janne Ahonen");
    }

    @Test
    public void testSetNullField() {
        kirja.setField(ID, null);
        assertEquals(kirja.getField(ID), null);
    }

    @Test
    public void testGetField() {
        assertEquals(kirja.getField(ID), "ID1");
    }

    @Test
    public void testToBibTex() {
        String tuloste = kirja.toBibTex();
        assertEquals(tuloste, "@book{ID1,\n" +
		"\tauthor = {Matti Nykänen},\n" +
		"\tpublisher = {Otava},\n" +
		"\ttitle = {Kotkan lento},\n" +
		"\tyear = {2002},\n" +
		"}");
    }
}
