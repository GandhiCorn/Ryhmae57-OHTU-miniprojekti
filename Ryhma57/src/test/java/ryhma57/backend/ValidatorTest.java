package ryhma57.backend;

import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ryhma57.references.Book;
import ryhma57.references.Reference;

public class ValidatorTest {
    
    private Validator validator;
    private ReferenceList list;
    
    public ValidatorTest() {
        validator = new Validator();
        list = new ReferenceList();
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
    public void testDuplicateIdCheck() {
        Reference book =  new Reference(ReferenceType.BOOK);
        book.setField(BibtexReferenceField.ID, "ID");
        book.setField(BibtexReferenceField.AUTHOR, "author");
        book.setField(BibtexReferenceField.PUBLISHER, "publisher");
        book.setField(BibtexReferenceField.YEAR, "year");
        book.setField(BibtexReferenceField.TITLE, "title");
        list.addReference(book);
        validator.setReferenceList(list);
        Reference book2 = new Reference(ReferenceType.BOOK);
        book2.setField(BibtexReferenceField.ID, "ID");
        book2.setField(BibtexReferenceField.AUTHOR, "author");
        book2.setField(BibtexReferenceField.PUBLISHER, "publisher");
        book2.setField(BibtexReferenceField.YEAR, "year");
        book2.setField(BibtexReferenceField.TITLE, "title");
        assertEquals("Duplicate ID", validator.validateReference(book2));
    }
    
    @Test
    public void testAuthorRequired() {
        Reference book =  new Reference(ReferenceType.BOOK);
        book.setField(BibtexReferenceField.ID, "ID");
        book.setField(BibtexReferenceField.PUBLISHER, "publisher");
        book.setField(BibtexReferenceField.YEAR, "year");
        book.setField(BibtexReferenceField.TITLE, "title");
        assertEquals("Invalid or required field: author", validator.validateReference(book));
    }
    
    @Test
    public void testTitleRequired() {
        Reference book =  new Reference(ReferenceType.BOOK);
        book.setField(BibtexReferenceField.ID, "ID");
        book.setField(BibtexReferenceField.AUTHOR, "author");
        book.setField(BibtexReferenceField.PUBLISHER, "publisher");
        book.setField(BibtexReferenceField.YEAR, "year");
        assertEquals("Invalid or required field: title", validator.validateReference(book));
    }
    
    @Test
    public void testNoAuthorRequiredIfEditorIsGiven() {
        Reference book =  new Reference(ReferenceType.BOOK);
        book.setField(BibtexReferenceField.ID, "ID");
        book.setField(BibtexReferenceField.EDITOR, "editor");
        book.setField(BibtexReferenceField.PUBLISHER, "publisher");
        book.setField(BibtexReferenceField.YEAR, "year");
        book.setField(BibtexReferenceField.TITLE, "title");
        assertEquals(null, validator.validateReference(book));
    }
}
