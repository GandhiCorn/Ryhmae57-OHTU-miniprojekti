package ryhma57.backend;

import static ryhma57.backend.BibtexReferenceField.*;

public class Book implements Reference {
    private String id;
    private String author;
    private String title;
    private String year;
    private String publisher;
    
    public Book(String id, String author, String title, String year, String publisher) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.year = year;
        this.publisher = publisher;
    }
    
    public String toBibTex() {
        return "@book{" + id + ",\n" + "author = {" + author + "},\n" + "title = {" + title + "},\n" + "year = {" + year + "},\n" + "publisher = {" + publisher + "},\n" + "}";
    }
    
    public void setField(BibtexReferenceField field, String value) {
        if (field == ID) {
            this.id = value;
        } else if (field == AUTHOR) {
            this.author = value;
        } else if (field == TITLE) {
            this.title = value;
        } else if (field == YEAR) {
            this.year = value;
        } else if (field == PUBLISHER) {
            this.publisher = value;
        } else {
            System.out.println("Invalid field");
        }
    }
    
    public String getField(BibtexReferenceField field) {
        if (field == ID) {
            return this.id;
        } else if (field == AUTHOR) {
            return this.author;
        } else if (field == TITLE) {
            return this.title;
        } else if (field == YEAR) {
            return this.year;
        } else if (field == PUBLISHER) {
            return this.publisher;
        } else {
            return "Invalid field";
        }
    }
    
}
