package Library;

import Library.entities.*;
import Library.serializers.BookSerializer;
import Library.serializers.LibrarySerializer;
import com.google.gson.GsonBuilder;
import java.util.List;
import static Library.utils.HibernateUtil.*;
import static Library.utils.HibernateUtil.query;
import static Library.entities.QBook.book;
import static Library.entities.QCustomer.customer;
import static Library.entities.QLibrary.library;


public class Controller {

    synchronized public void moveBookTOLibrary(Book book, Library newLibrary) {

        book.getLibrary().removeBook(book);
        newLibrary.addBook(book);
        newLibrary.save();
    }

    synchronized public void moveBookTOCustomer(Book book, Customer customer) {
        customer.addBook(book);
        book.setOwner(customer);
        customer.save();
    }

    synchronized public void returnBookToLibrary(Book book) {
        Customer owner = book.getOwner();
        owner.removeBook(book);
        book.setOwner(null);
        owner.save();
    }


    public void populate() {
        dbBegin();

        new Customer("Jan", "Kowalski", "608237394").save();
        new Customer("Jon", "Smith", "34344594").save();
        new Customer("Katy", "Rosenberg", "30843394").save();

        Library lib = new Library("Studencka", "02-123", "Wilcza", "Warszawa");
        lib.addBook(new Book("Wilcze stada", "Romanowski", 1987));
        lib.addBook(new Book("Neapol", "Kutrzeba", 2011));

        lib.addEmployee(new Manager("Tomasz", "Majewski", "233423234234234", "50000"));
        lib.addEmployee(new Librarian("Joanna", "Metzc", "23222489042690"));
        lib.save();

        lib = new Library("Malinowa", "22-450", "Maliny", "Kraków");
        lib.addBook(new Book("WWII", "Davis", 2004));
        lib.addBook(new Book("Zielnik Polski", "Tyl", 1999));
        lib.save();


        dbEnd();
    }

    synchronized public String getBooksJson() {
        dbBegin();

        List<Book> list = query().from(book).list(book);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Book.class, new BookSerializer());
        gsonBuilder.setPrettyPrinting();

        dbEnd();
        return gsonBuilder.create().toJson(list);
    }

    synchronized public String getLibrarysJson() {
        dbBegin();

        List<Library> list = query().from(library).list(library);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Library.class, new LibrarySerializer());
        gsonBuilder.setPrettyPrinting();

        String json = gsonBuilder.create().toJson(list);

        dbEnd();
        return json;
    }

    synchronized public String testDsl(Integer id) {

        dbBegin();

        Book b = query().from(book)
                .where(book.id.eq(id))
                .uniqueResult(book);

        List<Book> res = query().from(book)
                .where(book.id.gt(1))
                .list(book);

        System.out.println("-------------" + res.size());
        for(Book x:res)
            System.out.println(x);


        Book neapol = query().from(book).where(book.title.eq("Neapol")).uniqueResult(book);

        System.out.println("find-------Neapolauthor------" + neapol.getAuthor());


        neapol.setAuthor("Ksslimen");
        neapol.save();

        neapol = query().from(book).where(book.title.eq("Neapol")).uniqueResult(book);
        System.out.println("find-------Neapolauthor------" + neapol.getAuthor());

        dbEnd();
        return b==null?"Not found":b.toString();
    }

}
