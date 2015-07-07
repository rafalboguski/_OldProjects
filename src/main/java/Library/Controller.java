package Library;

import Library.entities.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.List;

import static Library.utils.HibernateUtil.*;


public class Controller {

    public void moveBookTOLibrary(Book book, Library newLibrary) {

        book.getLibrary().removeBook(book);
        newLibrary.addBook(book);
        libraryDAO.save(newLibrary);
    }

    public void moveBookTOCustomer(Book book, Customer customer) {
        customer.addBook(book);
        book.setOwner(customer);
        customerDAO.save(customer);
    }

    public void returnBookToLibrary(Book book) {
        Customer owner = book.getOwner();
        owner.removeBook(book);
        book.setOwner(null);
        customerDAO.save(owner);
    }


    public void populate() {
        getCurrentSession().beginTransaction();

        customerDAO.save(new Customer("Jan", "Kowalski", "608237394"));
        customerDAO.save(new Customer("Jon", "Smith", "34344594"));
        customerDAO.save(new Customer("Katy", "Rosenberg", "30843394"));

        Library lib = new Library("Studencka",
                "02-123",
                "Wilcza",
                "Warszawa");
        lib.addBook(new Book("Wilcze stada", "Romanowski", 1987));
        lib.addBook(new Book("Neapol", "Kutrzeba", 2011));

        lib.addEmployee(new Manager("Tomasz", "Majewski", "233423234234234", "50000"));
        lib.addEmployee(new Librarian("Joanna", "Metzc", "23222489042690"));
        libraryDAO.save(lib);

        lib = new Library("Malinowa",
                "22-450",
                "Maliny",
                "Kraków")
        ;
        lib.addBook(new Book("WWII", "Davis", 2004));
        lib.addBook(new Book("Zielnik Polski", "Tyl", 1999));
        libraryDAO.save(lib);


        getCurrentSession().getTransaction().commit();
        getCurrentSession().close();
    }

    public String getBooksJson() {
        getCurrentSession().beginTransaction();

        String text = "[";
        List<Book> list = bookDAO.findAll();
        for (int i = 0; i < list.size(); i++) {
            text += list.get(i).toJson();
            if (list.size() > 1 && i < list.size() - 1)
                text += ",";
        }
        text += "]";

        getCurrentSession().getTransaction().commit();
        getCurrentSession().close();
        return text;
    }

    public String getLibraysJson() {
        getCurrentSession().beginTransaction();

//        String text = "[";
        List<Library> list = libraryDAO.findAll();
//        for (int i = 0; i < list.size(); i++) {
//            text += list.get(i).toJson();
//            if (list.size() > 1 && i < list.size() - 1)
//                text += ",";
//        }
//        text += "]";
        //String text = new Gson().toJson(list);



        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Library.class, new LibrarySerializer());
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();


        String json = gson.toJson(list);






        getCurrentSession().getTransaction().commit();
        getCurrentSession().close();
        return json;
    }
}
