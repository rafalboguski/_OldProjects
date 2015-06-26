package Library;

import Library.entities.Book;
import Library.entities.Page;
import org.hibernate.*;

import static Library.utils.HibernateUtil.*;

public class ManageLibrary {




    public static void main(String[] argv) {

        session().beginTransaction();

        Book book = new Book("ksiazka", null);
        book.addPage(new Page(1, "pierwsza strona", book));
        book.addPage(new Page(2, "druga strona   ", book));
        book.addPage(new Page(3, "trzecia strona ", book));
        session().save(book);


        for (Book b : Book().findAll())
            System.out.println(b);

        session().getTransaction().commit();
        session().close();
        System.exit(0);
    }

    private static Session session() {
        return getCurrentSession();
    }

}
