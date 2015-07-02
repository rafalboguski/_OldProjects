package tests;

import Library.entities.Book;
import Library.entities.Library;
import Library.entities.Page;
import Library.utils.HibernateUtil;
import com.googlecode.genericdao.search.Search;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class BookTest {


    @Before
    public void setUp() throws Exception {
        HibernateUtil.getCurrentSession().beginTransaction();

        Library glowna = new Library();
        HibernateUtil.getCurrentSession().save(glowna);
        Book book = new Book("Year 1984", "Orwell", 1984, null, glowna);

        book.addPage(new Page(1, "Hello", book));
        book.addPage(new Page(2, "wor", book));
        book.addPage(new Page(3, "ld", book));
        HibernateUtil.getCurrentSession().save(book);


        HibernateUtil.getCurrentSession().getTransaction().commit();
        HibernateUtil.getCurrentSession().close();
    }

//
//    @Test
//    public void testCreate(){
//
//        HibernateUtil.getCurrentSession().beginTransaction();
//
//        Search search = new Search();
//        search.addFilterEqual("title", "Year 1984");
//        List<Book> books = HibernateUtil.Book().search(search);
//
//        assertEquals(1,books.size());
//        Book result = books.get(0);
//        assertEquals(result.getTitle(), "Year 1984");
//        assertEquals(result.getAuthor(), "Orwell");
//        assertEquals(result.getTitle(), "Year 1984");
//        assertEquals(result.getPages().get(0).getText(), "Hello");
//
//        HibernateUtil.getCurrentSession().getTransaction().commit();
//        HibernateUtil.getCurrentSession().close();
//
//    }

    @Test
    public void testDelete() {


        HibernateUtil.getCurrentSession().beginTransaction();

        Search search = new Search();
        search.addFilterEqual("title", "Year 1984");
        List<Book> books = HibernateUtil.Book().search(search);
        Book result = books.get(0);

        HibernateUtil.getCurrentSession().save(result);
        HibernateUtil.Book().remove(result);

        books = HibernateUtil.Book().search(search);
        assertEquals(0, books.size());

        HibernateUtil.getCurrentSession().getTransaction().commit();
        HibernateUtil.getCurrentSession().close();
    }
}