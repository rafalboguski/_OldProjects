package Library.entities;

import Library.utils.HibernateUtil;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {


    @Id
    @GeneratedValue
    @Column(name = "BOOK_ID")
    private int id;

    private String title;
    private String author;
    private int releaseYear;



    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer owner;

    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID")
    private Library library;


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
        return "Book: " + title + "  ";
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
}
