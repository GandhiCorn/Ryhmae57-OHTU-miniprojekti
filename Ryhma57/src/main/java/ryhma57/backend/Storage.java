package ryhma57.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import ryhma57.references.Reference;

public class Storage {

    private ObjectOutputStream out;
    private ObjectInputStream in;
    private PrintWriter writer;
    private ReferenceList list;
    private Validator validator;
    

    public Storage() {
        list = new ReferenceList();
        validator = new Validator();
        getPreviousReferenceList();
    }

    public String storeNewReference(Reference reference) {
        String message = validator.validateReference(reference);
        if (message != null) {
            return message;
        }
        if (!validator.hasField(reference, BibtexReferenceField.ID)) {

        String firstletters = "";   
            for (String author : reference.getAuthors()) {
                String firstletter = "" + author.charAt(0);
                firstletters = firstletters + firstletter;
            }

            String newID = firstletters + reference.getField(BibtexReferenceField.YEAR);
            reference.setField(BibtexReferenceField.ID, newID);
        }
        if (validator.hasIDUsed(reference.getID())) {
            for (char i = 'a'; i <= 'z'; i++) {
                String newID = reference.getID() + i;
                if (!validator.hasIDUsed(newID)) {
                    reference.setField(BibtexReferenceField.ID, newID);
                    break;
                }
            }
        }
        try {
            out = new ObjectOutputStream(new FileOutputStream("db.txt"));
            list.addReference(reference);
            out.writeObject(list);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
            return "exception happened";
        }
        validator.setReferenceList(list);
        return null;
    }

    public void removeReference(Reference reference) {
        try {
            writer = new PrintWriter("db.txt");
            writer.print("");
            writer.close();
            list.deleteReference(reference);
            out = new ObjectOutputStream(new FileOutputStream("db.txt"));
            out.writeObject(list);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }
        validator.setReferenceList(list);
    }

    public void generateBibTex() {
        try {
            writer = new PrintWriter("references.bib", "UTF-8");
            writer.print(list.toBibTex());
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(StorageJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getPreviousReferenceList() {
        try {
            in = new ObjectInputStream(new FileInputStream("db.txt"));
            list = (ReferenceList) in.readObject();
        } catch (FileNotFoundException ex) {
            /* Do nothing if the file doesn't exist */
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }
        validator.setReferenceList(list);
    }

    /*TODO This propably should be refactored */
    public ReferenceList getReferenceList() {
        return list;
    }

    public static void removeTmpFiles() {
        try {
            Files.delete(Paths.get("references.bib"));
        } catch (IOException ex) {
        }
        try {
            Files.delete(Paths.get("db.txt"));
        } catch (IOException ex) {
        }
    }
}
