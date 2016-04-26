package ryhma57.references;

import ryhma57.references.Book;
import static ryhma57.backend.BibtexReferenceField.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class InproceedingsTest {

    private Inproceedings inproceedings;

    public InproceedingsTest() {
        inproceedings = new Inproceedings();
        inproceedings.setField(ID, "ID1");
        inproceedings.setField(AUTHOR, "Matti Nykänen");
        inproceedings.setField(TITLE, "Kotkan lento");
        inproceedings.setField(YEAR, "2002");
        inproceedings.setField(PUBLISHER, "Iltasanomat");
    }

    @Test
    public void testSetField() {
        inproceedings.setField(AUTHOR, "Janne Ahonen");
        assertEquals(inproceedings.getField(AUTHOR), "Janne Ahonen");
    }

    @Test
    public void testGetField() {
        assertEquals("Iltasanomat", inproceedings.getField(PUBLISHER));
    }

    @Test
    public void testToBibTex() {
        String tuloste = inproceedings.toBibTex();
        assertEquals(tuloste, "@inproceedings{ID1,\n"
                + "\tauthor = {Matti Nykänen},\n"
                + "\tpublisher = {Iltasanomat},\n"
                + "\ttitle = {Kotkan lento},\n"
                + "\tyear = {2002},\n"
                + "}");
    }
}
