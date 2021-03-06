//package tests;
//
//import Library.entities.Book;
//import Library.entities.Library;
//import Library.entities.Page;
//import Library.utils.HibernateUtil;
//import com.googlecode.genericdao.search.Search;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//
//public class BookTest {
//
//
//    private boolean setUpIsDone = false;
//
//    @Before
//    public void setUp() throws Exception {
//        if (setUpIsDone) {
//            return;
//        }
//        HibernateUtil.getCurrentSession().beginTransaction();
//
//        Library glowna = new Library();
//        HibernateUtil.getCurrentSession().save(glowna);
//        Book book = new Book("Year 1984", "Orwell", 1984, glowna);
//
//        HibernateUtil.getCurrentSession().save(book);
//
//
//        HibernateUtil.getCurrentSession().getTransaction().commit();
//        HibernateUtil.getCurrentSession().close();
//    }
//
//
//    @Test
//    public void testCreate() {
//
//        HibernateUtil.getCurrentSession().beginTransaction();
//
//        Search search = new Search();
//        search.addFilterEqual("title", "Year 1984");
//        List<Book> books = HibernateUtil.Book().search(search);
//
//        assertEquals(1, books.size());
//        Book result = books.get(0);
//        assertEquals(result.getTitle(), "Year 1984");
//        assertEquals(result.getAuthor(), "Orwell");
//        assertEquals(result.getTitle(), "Year 1984");
//
//        HibernateUtil.getCurrentSession().getTransaction().commit();
//        HibernateUtil.getCurrentSession().close();
//
//    }
//
//    @Test
//    public void testDelete() {
//
//        HibernateUtil.getCurrentSession().beginTransaction();
//
//        Search search = new Search();
//        search.addFilterEqual("title", "Year 1984");
//        List<Book> books = HibernateUtil.Book().search(search);
//        Book result = books.get(0);
//
//        HibernateUtil.getCurrentSession().save(result);
//        HibernateUtil.Book().remove(result);
//
//        books = HibernateUtil.Book().search(search);
//        assertNotNull(books.get(0));
//
//        HibernateUtil.getCurrentSession().getTransaction().commit();
//        HibernateUtil.getCurrentSession().close();
//    }
//
//
//}