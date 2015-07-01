package Library.entities;

import Library.utils.HibernateUtil;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

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

    public Book() {
        this.title = "null";
        this.pages = null;
    }


    public void addPage(Page page) {
        pages.add(page);
        page.setBook(this);
        HibernateUtil.getCurrentSession().save(page);
    }

    //----------------------------------------------------------------------------

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    //----------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Book: " + title + "  " + pages;
    }
}
