package ryhma57.backend;

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
        return "@book{" + id + ",\nauthor = {" + author + "},\ntitle = {" + title + "},\nyear = {" + year + "},\npublisher = {" + publisher + "},\n}";
    }
    
}
