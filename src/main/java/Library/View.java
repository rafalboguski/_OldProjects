package Library;

import Library.entities.*;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

import static Library.utils.HibernateUtil.*;
import static spark.Spark.*;
public class View {


    public static void main(String[] argv) {

        Controller controller = new Controller();

        controller.populate();

//
//        getCurrentSession().beginTransaction();
//
//        controller.moveBookTOLibrary(Book().find("Zielnik Polski"), Library().find("Studencka"));
//
//        controller.moveBookTOCustomer(Book().find("Zielnik Polski"), Customer().find(1));
//        controller.moveBookTOCustomer(Book().find("Neapol"), Customer().find(2));
//        controller.returnBookToLibrary(Book().find("Neapol"));
//
//        getCurrentSession().getTransaction().commit();
//        getCurrentSession().close();


        get("/hello", (req, res) -> {

            return controller.getAllBooks();
        });




    }




}
