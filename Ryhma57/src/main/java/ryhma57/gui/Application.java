package ryhma57.gui;

import java.util.EnumMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ryhma57.backend.BibtexReferenceField;
import ryhma57.references.Book;
import ryhma57.references.Reference;
import ryhma57.backend.ReferenceList;
import ryhma57.backend.ReferenceType;
import ryhma57.backend.Storage;

/**
 * This is the main class currently.
 */
public class Application {

    private Storage storage;
    private Window window;

    public Application() {
        this.storage = new Storage();
    }

    public static void main(String[] args) {
        Application app = new Application();
        Window window = new Window(app);
        app.run(window);
    }

    public void run(Window window) {
        this.window = window;
        /* this is currently for testing */
        List<Reference> list = storage.getReferenceList().getAll();
        for (Reference ref : list) {
            window.getListView().createRow(ref.getID(), ref.getField(BibtexReferenceField.TITLE));
        }
        window.setVisible(true);
    }

    public void generateBibTex() {
        storage.generateBibTex();
    }

    public void createNewReference(ReferenceType type, EnumMap<BibtexReferenceField, String> fields) {
        System.out.println("Create the book reference in the backend");

        Reference ref = null;
        try {
            ref = (Reference) type.getReferenceClass().newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (BibtexReferenceField field : fields.keySet()) {
            ref.setField(field, fields.get(field));
        }
        String error = storage.storeNewReference(ref);
        if (error != null) {
            window.setErrorMessage(error);
        } else {
            window.setErrorMessage("Reference saved successfully");
            window.getListView().createRow(ref.getID(), ref.getField(BibtexReferenceField.TITLE));
        }
    }

    public void removeReference(int index) {
        window.getListView().removeRow(index);
        Reference toBeDeleted = storage.getReferenceList().get(index);
        storage.removeReference(toBeDeleted);
    }
}
