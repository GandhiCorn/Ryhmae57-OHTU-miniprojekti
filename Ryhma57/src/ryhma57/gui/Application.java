package ryhma57.gui;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.EnumMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import ryhma57.backend.BibtexReferenceField;
import ryhma57.backend.Book;
import ryhma57.backend.Reference;
import ryhma57.backend.ReferenceList;

/**
 * This is the main class currently.
 */
public class Application {
    
    private ReferenceList referenceList;
    
    public Application() {
        this.referenceList = new ReferenceList();
    }
    
    public static void main(String[] args) {
        Application app = new Application();
        Window window;
        window = new Window(app);

        window.setVisible(true);
        System.out.println("test");
    }

    public void generateBibTex() {
        PrintWriter writer;
        System.out.println("Generate the bibtext file in the backend");

        try {
            writer = new PrintWriter("database.bib", "UTF-8");
            writer.print(this.referenceList.toBibTex());
            writer.close();

        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createNewBookReference(EnumMap<BibtexReferenceField, String> fields) {
        System.out.println("Create the book reference in the backend");

        String id = fields.get(BibtexReferenceField.ID);
        String author = fields.get(BibtexReferenceField.AUTHOR);
        String title = fields.get(BibtexReferenceField.TITLE);
        String year = fields.get(BibtexReferenceField.YEAR);
        String publisher = fields.get(BibtexReferenceField.PUBLISHER);

        Reference ref = new Book(id, author, title, year, publisher);
        this.referenceList.addReference(ref);

        /* Alternative way to push the changes into backend */
        //Reference ref = new Reference();
        //this.referenceList.addReference(ref);
        //
        //for (BibtexReferenceField field : fields.keySet()) {
        //    ref.setField(field, fields.get(field));
        //}
    }
}
