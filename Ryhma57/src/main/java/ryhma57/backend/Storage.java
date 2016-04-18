package ryhma57.backend;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ryhma57.references.Reference;

public class Storage {
    private final Gson gson;
    private PrintWriter jsonWriter;
    private PrintWriter bibWriter;
    private ReferenceList referenceList;
    
    public Storage() {
        gson = new Gson();
        referenceList = new ReferenceList();
    }

    public void storeNewReference(Reference reference) {
        try {
            jsonWriter = new PrintWriter("database.json", "UTF-8");
            referenceList.addReference(reference);
            jsonWriter.print(gson.toJson(referenceList));
            jsonWriter.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void generateBibTex() {
        try {
            bibWriter = new PrintWriter("database.bib", "UTF-8");
            bibWriter.print(referenceList.toBibTex());
            bibWriter.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getPreviousReferenceList() {
        
    }
}
