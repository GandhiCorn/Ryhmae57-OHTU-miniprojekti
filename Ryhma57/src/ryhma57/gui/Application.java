package ryhma57.gui;

import java.util.EnumMap;
import ryhma57.backend.BibtexReferenceField;

/**
 * This is the main class currently.
 */
public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        Window window;
        window = new Window(app);

        window.setVisible(true);
        System.out.println("test");
    }

    public void generateBibTex() {
        //XXX do something here
        System.out.println("Generate the bibtext file in the backend");
    }

    public void createNewBookReference(EnumMap<BibtexReferenceField, String> fields) {
        //XXX do something here
        System.out.println("Create the book reference in the backend");

        /* Push the changes into backend */
        //Reference ref = new Reference();
        //ref = this.referenceList.addReference(ref);
        //
        //for (BibtexReferenceField field : fields.keySet()) {
        //    ref.setField(field, fields.get(field));
        //}
    }
}
