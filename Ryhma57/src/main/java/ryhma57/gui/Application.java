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
    private boolean searchMode;

    public Application() {
        this.storage = new Storage();
        this.searchMode = false;
    }

    public static void main(String[] args) {
        Application app = new Application();
        Window window = new Window(app);
        app.run(window);
    }

    public void run(Window window) {
        this.window = window;
        if(window != null) {
            updateViewList();
            window.setVisible(true);
        }
    }

    private void updateViewList() {
        List<Reference> list = storage.getReferenceList().getAll();
        window.getListView().clear();
        for (Reference ref : list) {
            window.getListView().createRow(ref.getID(), ref.getField(BibtexReferenceField.TITLE));
        }
    }

    public void generateBibTex() {
        storage.generateBibTex();
    }

    public void createNewReference(ReferenceType type, EnumMap<BibtexReferenceField, String> fields) {
        
        Reference ref;
        try {
            ref = (Reference) type.getReferenceClass().newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        for (BibtexReferenceField field : fields.keySet()) {
            ref.setField(field, fields.get(field));
        }
        String error = storage.storeNewReference(ref);
        if(window == null) return;
        if (error != null) {
            window.setErrorMessage(error);
        } else {
            window.setErrorMessage("Reference saved successfully");
            window.getListView().createRow(ref.getID(), ref.getField(BibtexReferenceField.TITLE));
        }
    }

    public void search(String query) {
        if(query.length() == 0) {
            updateViewList();
            this.searchMode = false;
        } else {
            System.out.println("Search with query: " + query);
            window.getListView().clear();
            for(int i = 1; i < 10; i++) {
                window.getListView().createRow("abc"+i, "Search result");
            }
            this.searchMode = true;
        }
    }

    public ReferenceList getList() {
        return storage.getReferenceList();
    }

    public void removeReference(int index) {
        Reference reference;

        if(window != null) {
            window.getListView().removeRow(index);
        }
        if(this.searchMode) {
            reference = null;/* get the right reference from search list */
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, new UnsupportedOperationException("Not implemented yet"));
            System.exit(1);
            return;
        } else {
            reference = storage.getReferenceList().get(index);
        }
        storage.removeReference(reference);
    }
}
