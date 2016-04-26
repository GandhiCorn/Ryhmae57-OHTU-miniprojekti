package ryhma57.backend;

import java.util.EnumMap;
import ryhma57.backend.*;
import ryhma57.gui.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class ApplicationTest {
    // for easyB testing 
    @Test
    public void test() {
        Application app = new Application();
        Window window = new Window(app);
        app.run(window);
        EnumMap<BibtexReferenceField, String> fields = new EnumMap<BibtexReferenceField, String>(BibtexReferenceField.class);
        fields.put(BibtexReferenceField.ID, "test");
        app.createNewReference(fields);
        assertTrue(true);
    }
}