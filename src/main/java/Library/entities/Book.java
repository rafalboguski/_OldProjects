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


    @OneToMany(mappedBy = "book", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Page> pages;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer owner;

    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID")
    private Library library;


    public Book(String title, String author, int year, ArrayList<Page> pages, Library library) {
        this.title = title;
        this.author = author;
        this.releaseYear = year;
        this.pages = pages != null ? pages : new ArrayList<Page>();
        this.library = library;

    }

    public Book() {

    }


    //----------------------------------------------------------------------------


    public void addPage(Page page) {
        pages.add(page);
        page.setBook(this);
        HibernateUtil.getCurrentSession().save(page);
    }

    //----------------------------------------------------------------------------

    public List<Page> getPages() {
        return pages;
    }



    //----------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Book: " + title + "  " + pages;
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
}
