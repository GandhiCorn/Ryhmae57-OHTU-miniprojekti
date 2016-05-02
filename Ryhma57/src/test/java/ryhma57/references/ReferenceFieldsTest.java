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
import static org.junit.Assert.*;
import org.junit.Test;
import ryhma57.backend.BibtexReferenceField;
import ryhma57.backend.ReferenceType;

/**
 *
 * @author Simo
 */
public class ReferenceFieldsTest {

    public ReferenceFieldsTest() {
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
    public void getAllFieldsReturnsFields() {
        EnumSet<BibtexReferenceField> fields = ReferenceFields.getAllFields(ReferenceType.BOOK);
        assertNotNull(fields);
        assertFalse(fields.isEmpty());
    }

    @Test
    public void getRequiredFieldsReturnsFields() {
        EnumSet<BibtexReferenceField> fields = ReferenceFields.getRequiredFields(ReferenceType.BOOK);
        assertNotNull(fields);
        assertFalse(fields.isEmpty());
    }

    @Test
    public void getOptionalFieldsReturnsFields() {
        EnumSet<BibtexReferenceField> fields = ReferenceFields.getOptionalFields(ReferenceType.BOOK);
        assertNotNull(fields);
        assertFalse(fields.isEmpty());
    }
}
