package ryhma57.gui;

import java.util.EnumMap;
import ryhma57.backend.BibtexReferenceField;
import ryhma57.references.Book;
import ryhma57.references.Reference;
import ryhma57.backend.ReferenceList;
import ryhma57.backend.Storage;

/**
 * This is the main class currently.
 */
public class Application {
    
    private ReferenceList referenceList;
    private Storage storage;
    
    public Application() {
        this.referenceList = new ReferenceList();
        this.storage = new Storage();
    }
    
    public static void main(String[] args) {
        Application app = new Application();
        Window window;
        window = new Window(app);

        window.setVisible(true);
        System.out.println("test");
    }

    public void generateBibTex() {
        storage.generateBibTex();
    }

    public String createNewBookReference(EnumMap<BibtexReferenceField, String> fields) {
        System.out.println("Create the book reference in the backend");

        Reference ref = new Book();

        ref.setID(fields.get(BibtexReferenceField.ID));
        fields.remove(BibtexReferenceField.ID);

        for (BibtexReferenceField field : fields.keySet()) {
            boolean result;
            result = ref.setField(field, fields.get(field));
            if(!result) {
                return "Invalid or required field: " + field.getName();
            }
        }       
        storage.storeNewReference(ref);
        
        return null;
    }
}
