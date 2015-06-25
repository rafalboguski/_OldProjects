package Library;

import Library.dao.BookDAOImpl;
import Library.entities.Book;
import Library.entities.Page;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

public class ManageLibrary {


    static BookDAOImpl dao = new BookDAOImpl();

    public static void main(String[] argv) {


        session().beginTransaction();

        Book book = new Book("ksiazka", null);

        List<Page> pages = new ArrayList<Page>();
        pages.add(new Page(1, "pierwsza strona", book));
        pages.add(new Page(2, "druga strona", book));
        pages.add(new Page(3, "trzecia strona", book));

        for (Page p : pages)
            session().save(p);

        book.setPages(pages);

        session().save(book);


        List<Book> books = dao.findAll();


        for (Book b : books)
            System.out.println(b);

        session().getTransaction().commit();
        session().close();


        System.exit(0);
    }

    private static Session session() {
        return HibernateUtil.getCurrentSession();
    }

}
