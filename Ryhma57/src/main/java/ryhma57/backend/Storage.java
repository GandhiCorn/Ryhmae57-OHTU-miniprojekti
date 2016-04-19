package ryhma57.backend;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ryhma57.references.Reference;

public class Storage {
    private final Gson gson;
    private PrintWriter writer;
    private JsonReader reader;
    private ReferenceList referenceList;
    
    public Storage() {
        gson = new Gson();
        referenceList = new ReferenceList();
    }

    public void storeNewReference(Reference reference) {
        try {
            writer = new PrintWriter("database.json", "UTF-8");
            referenceList.addReference(reference);
            writer.print(gson.toJson(this.referenceList));
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void generateBibTex() {
        try {
            writer = new PrintWriter("database.bib", "UTF-8");
            writer.print(referenceList.toBibTex());
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getPreviousReferenceList() {
        try {
            reader = new JsonReader(new FileReader("database.json"));
            referenceList = gson.fromJson(reader, ReferenceList.class);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
