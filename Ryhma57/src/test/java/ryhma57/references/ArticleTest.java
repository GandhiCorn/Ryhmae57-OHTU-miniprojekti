package ryhma57.references;

import ryhma57.references.Book;
import static ryhma57.backend.BibtexReferenceField.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArticleTest {

    private Article article;

    public ArticleTest() {
        article = new Article();
	article.setField(ID, "ID1");
	article.setField(AUTHOR, "Rauno Mattila");
	article.setField(TITLE, "Mäkihyppy on vastenmielistä");
	article.setField(YEAR, "2012");
	article.setField(PUBLISHER, "Iltasanomat");
    }

    @Test
    public void testSetField() {
        article.setField(AUTHOR, "Janne Ahonen");
        assertEquals(article.getField(AUTHOR), "Janne Ahonen");
    }


    @Test
    public void testGetField() {
        assertEquals("Iltasanomat", article.getField(PUBLISHER));
    }

    @Test
    public void testToBibTex() {
        String tuloste = article.toBibTex();
        assertEquals(tuloste, "@article{ID1,\n" +
		"\tauthor = {Rauno Mattila},\n" +
		"\tpublisher = {Iltasanomat},\n" +
		"\ttitle = {Mäkihyppy on vastenmielistä},\n" +
		"\tyear = {2012},\n" +
		"}");
    }
}
