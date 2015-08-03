package Library.entities;

import Library.utils.HibernateUtil;
import com.google.gson.annotations.Expose;
import com.mysema.query.hql.hibernate.HibernateQuery;
import com.mysema.query.types.expr.EBoolean;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static Library.utils.HibernateUtil.getCurrentSession;

@Entity @Data
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


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseYear=" + releaseYear +
                ", owner=" + owner +
                ", library=" + library.getName() +
                '}';
    }


}
