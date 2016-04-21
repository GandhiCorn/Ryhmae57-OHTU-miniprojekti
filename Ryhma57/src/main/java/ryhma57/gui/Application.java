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
    private Window window;

    public Application() {
        this.referenceList = new ReferenceList();
        this.storage = new Storage();
        this.storage.getPreviousReferenceList();
    }

    public static void main(String[] args) {
        Application app = new Application();
        Window window = new Window(app);
        app.run(window);
    }

    public void run(Window window) {
        this.window = window;
        window.setVisible(true);
    }

    public void generateBibTex() {
        storage.generateBibTex();
    }

    public void createNewBookReference(EnumMap<BibtexReferenceField, String> fields) {
        System.out.println("Create the book reference in the backend");

        Reference ref = new Book();

        ref.setID(fields.get(BibtexReferenceField.ID));
        fields.remove(BibtexReferenceField.ID);

        for (BibtexReferenceField field : fields.keySet()) {
            boolean result;
            result = ref.setField(field, fields.get(field));
            if(!result) {
                window.setErrorMessage("Invalid or required field: " + field.getName());
                return;
            }
        }       
        storage.storeNewReference(ref);
        window.getListView().createRow(ref.getID(), ref.getField(BibtexReferenceField.TITLE));
    }
}
