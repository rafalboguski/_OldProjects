package Library.entities;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book extends GenericDAOImpl {

    @Id
    @GeneratedValue
    @Column(name = "BOOK_ID")
    private int id;

    private String title;

    @OneToMany(mappedBy = "book")
    private List<Page> pages;


    public static List<Book> getAll(Session session) {
        return session.createQuery("FROM Book").list();
    }


    public Book(String title, List<Page> pages) {
        this.title = title;
        this.pages = pages;
    }

    public Book() {
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public List<Page> getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Book: " + title + "  " + pages;
    }
}
