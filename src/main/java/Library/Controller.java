package Library;

import Library.entities.*;
import Library.utils.HibernateUtil;
import com.google.gson.Gson;
import net.sf.json.JSONObject;

import java.util.List;

import static Library.utils.HibernateUtil.Book;
import static Library.utils.HibernateUtil.Library;
import static Library.utils.HibernateUtil.getCurrentSession;


public class Controller {

    public void moveBookTOLibrary(Book book, Library newLibrary) {

        book.getLibrary().removeBook(book);
        newLibrary.addBook(book);
        HibernateUtil.Library().save(newLibrary);
    }

    public void moveBookTOCustomer(Book book, Customer customer) {
        customer.addBook(book);
        book.setOwner(customer);
        HibernateUtil.Customer().save(customer);
    }

    public void returnBookToLibrary(Book book) {
        Customer owner = book.getOwner();
        owner.removeBook(book);
        book.setOwner(null);
        HibernateUtil.Customer().save(owner);
    }



    public void populate() {
        getCurrentSession().beginTransaction();

        HibernateUtil.Customer().save(new Customer("Jan", "Kowalski", "608237394"));
        HibernateUtil.Customer().save(new Customer("Jon", "Smith", "34344594"));
        HibernateUtil.Customer().save(new Customer("Katy", "Rosenberg", "30843394"));

        Library lib = new Library("Studencka",
                "02-123",
                "Wilcza",
                "Warszawa");
        lib.addBook(new Book("Wilcze stada", "Romanowski", 1987));
        lib.addBook(new Book("Neapol", "Kutrzeba", 2011));

        lib.addEmployee(new Manager("Tomasz", "Majewski", "233423234234234", "50000"));
        lib.addEmployee(new Librarian("Joanna", "Metzc", "23222489042690"));
        Library().save(lib);

        lib = new Library("Malinowa",
                "22-450",
                "Maliny",
                "Kraków")
        ;
        lib.addBook(new Book("WWII", "Davis", 2004));
        lib.addBook(new Book("Zielnik Polski", "Tyl", 1999));
        ;
        Library().save(lib);


        getCurrentSession().getTransaction().commit();
        getCurrentSession().close();
    }

    public String getAllBooks() {
        getCurrentSession().beginTransaction();

        String text = "[";
        List<Book> list = Book().findAll();
        for (Book b : list) {
            JSONObject obj = new JSONObject();

            obj.put("title", b.getTitle());
            obj.put("author", b.getAuthor());
            obj.put("library_id", b.getLibrary().getId());
            //obj.put("owner_id", b.getOwner().getId());

            text += obj +",";
        }
        text+="]";

        getCurrentSession().getTransaction().commit();
        getCurrentSession().close();
        return  text;
    }
}
