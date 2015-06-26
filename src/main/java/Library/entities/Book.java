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

    @OneToMany(mappedBy = "book")
    private List<Page> pages;



    public Book(String title, List<Page> pages) {
        this.title = title;
        this.pages = pages != null ? pages : new ArrayList<Page>();
    }

    private Book() {
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public void addPage(Page page) {
        pages.add(page);
        page.setBook(this);
        HibernateUtil.getCurrentSession().save(page);
    }

    public List<Page> getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Book: " + title + "  " + pages;
    }
}
