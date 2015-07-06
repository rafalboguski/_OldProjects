package Library;

import Library.entities.*;
import org.hibernate.*;

import java.util.ArrayList;

import static Library.utils.HibernateUtil.*;

public class ManageLibrary {


    public static void main(String[] argv) {

        populate();


        session().beginTransaction();

        Book().moveBookTOLibrary(Book().find("Zielnik Polski"), Library().find("Studencka"));

        Book().moveBookTOCustomer(Book().find("Zielnik Polski"), Customer().find(1));
        Book().moveBookTOCustomer(Book().find("Neapol"),Customer().find(2));
        Book().returnBookToLibrary(Book().find("Neapol"));

        session().getTransaction().commit();
        session().close();

        System.exit(0);
    }

    private static void populate() {
        session().beginTransaction();

        Customer().save(new Customer("Jan", "Kowalski", "608237394"));
        Customer().save(new Customer("Jon", "Smith", "34344594"));
        Customer().save(new Customer("Katy", "Rosenberg", "30843394"));

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


        session().getTransaction().commit();
        session().close();
    }

    private static Session session() {
        return getCurrentSession();
    }

}
