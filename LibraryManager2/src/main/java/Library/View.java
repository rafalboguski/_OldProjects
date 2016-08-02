package Library;

import static spark.Spark.*;


public class View {

    synchronized public static void main(String[] argv) {

        Controller controller = new Controller();
        controller.populate();


        get("/book",    (req, res) -> controller.getBooksJson());

        get("/library", (req, res) -> controller.getLibrarysJson());

        get("/dsl/:id", (req, res) -> controller.testDsl(Integer.valueOf(req.params("id"))));

    }

}
