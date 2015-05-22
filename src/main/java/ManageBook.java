import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Iterator;
import java.util.List;


public class ManageBook {
    private static SessionFactory factory;
    public static void main(String[] args) {
        try{

            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        ManageBook ME = new ManageBook();

      /* Add few Book records in database */
        Integer empID1 = ME.addBook("Zara", "Ali", 1000);
        Integer empID2 = ME.addBook("Daisy", "Das", 5000);
        Integer empID3 = ME.addBook("John", "Paul", 10000);

//      /* List down all the Books */
//        ME.listBooks();
//
//      /* Update Book's records */
//        ME.updateBook(empID1, 5000);
//
//      /* Delete an Book from the database */
//        ME.deleteBook(empID2);
//
      /* List down new list of the Books */
        ME.listBooks();
    }


    public Integer addBook(String title, String autor, int pages){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer BookID = null;
        try{
            tx = session.beginTransaction();
            Book Book = new Book(title, autor, pages);
            BookID = (Integer) session.save(Book);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        System.out.println("Add Book id: "+ BookID.intValue());
        return BookID;
    }


    public void listBooks( ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List Books = session.createQuery("FROM Book").list();
            for (Iterator iterator = Books.iterator(); iterator.hasNext();){
                Book Book = (Book) iterator.next();
                System.out.print("title: " + Book.getTitle());
                System.out.print("  autor: " + Book.getAutor());
                System.out.println("  Pages: " + Book.getPages());
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    /* Method to UPDATE salary for an Book */
    public void updateBook(Integer BookID, int salary ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Book Book =
                    (Book)session.get(Book.class, BookID);
            Book.setPages(salary);
            session.update(Book);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    /* Method to DELETE an Book from the records */
    public void deleteBook(Integer BookID){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Book Book =
                    (Book)session.get(Book.class, BookID);
            session.delete(Book);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}