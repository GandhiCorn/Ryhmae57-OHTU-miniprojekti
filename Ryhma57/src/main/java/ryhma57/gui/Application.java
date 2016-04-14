package ryhma57.gui;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.EnumMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import ryhma57.backend.BibtexReferenceField;
import ryhma57.references.Book;
import ryhma57.references.Reference;
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

    public String createNewBookReference(EnumMap<BibtexReferenceField, String> fields) {
        System.out.println("Create the book reference in the backend");

        Reference ref = new Book();
        this.referenceList.addReference(ref);

        ref.setID(fields.get(BibtexReferenceField.ID));
        fields.remove(BibtexReferenceField.ID);

        for (BibtexReferenceField field : fields.keySet()) {
            boolean result;
            result = ref.setField(field, fields.get(field));
            if(!result) {
                return "Invalid or required field: " + field.getName();
            }
        }
        return null;
    }
}
