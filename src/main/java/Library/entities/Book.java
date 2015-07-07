package Library.entities;

import Library.utils.HibernateUtil;
import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {


    @Id
    @GeneratedValue
    @Column(name = "BOOK_ID")
    private int id;

    @Expose
    private String title;
    @Expose
    private String author;
    @Expose
    private int releaseYear;



    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer owner;

    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID")
    private  Library library;


    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.releaseYear = year;

    }

    public Book() {
    }
//----------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Book [title="+title+", author="+author+", releaseYear="+releaseYear+", library_id="+library.getId()+", owner_id="+owner+"]";
    }

    public String toJson(){

        String tmp = "{ \"title\":\"" + title +
                "\",\"author\":\"" + author +
                "\",\"releaseYear\":\"" + releaseYear +
                "\",\"library\":\"" + library.getId() +
                "\"";
        if (owner != null)
            tmp += ",\"owner\":\"" + owner.getId() + "\"";

        return tmp + "}";

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }


    public void setLibrary(Library library) {
        this.library = library;
    }

    public Library getLibrary() {
        return library;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }


    public int getId() {
        return id;
    }
}
