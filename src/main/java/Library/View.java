package Library;

import Library.utils.*;

import static spark.Spark.*;
public class View {


    synchronized public static void main(String[] argv) {

//        Thread.setDefaultUncaughtExceptionHandler( MyUncaughtExceptionHandler );

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


        get("/book", (req, res) -> {
            return controller.getBooksJson();
        });

        get("/library", (req, res) -> {
            return controller.getLibrarysJson();
        });

        get("/dsl/:id", (req, res) -> {
            return controller.testDsl(Integer.valueOf(req.params("id")));
        });



    }




}
