//import OneToMany.Department;
//import OneToMany.Employee;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.AnnotationConfiguration;
//
//import java.util.List;
//
//public class ManageBook {
//    private static SessionFactory factory;
//    public static void main(String[] args) {
//        try{
//            factory = new AnnotationConfiguration().configure().buildSessionFactory();
//        }catch (Throwable ex) {
//            System.err.println("Failed to create sessionFactory object." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//        ManageBook ME = new ManageBook();
//
//
//
//        Integer empID1 = ME.addBook("a", "d", 1000);
//        Integer empID2 = ME.addBook("b", "e", 5000);
//        Integer empID3 = ME.addBook("c", "f", 10000);
//
//        ME.listBooks();
//
//        ME.listBooks();
//    }
//
//
//    public Integer addBook(String title, String autor, int pages){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        Integer bookID = null;
//        try{
//            tx = session.beginTransaction();
//            Book book = new Book(title, autor, pages);
//            bookID = (Integer) session.save(book);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//        System.out.println("Add Book id: "+ bookID.intValue());
//        return bookID;
//    }
//
//
//    public void listBooks( ){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            List Books = session.createQuery("FROM Book").list();
//            tx.commit();
//            System.out.println("List books {");
//            for (Book book:(List<Book>)Books){
//                System.out.print("  {title: " + book.getTitle());
//                System.out.print("  autor: " + book.getAutor());
//                System.out.println("  Pages: " + book.getPages()+"},");
//            }
//            System.out.println("}");
//
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
//
//    public void updateBook(Integer BookID, int salary ){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            Book Book =
//                    (Book)session.get(Book.class, BookID);
//            Book.setPages(salary);
//            session.update(Book);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
//
//    public void deleteBook(Integer BookID){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            System.out.println("Delete Book id: "+ BookID.intValue());
//            Book Book =
//                    (Book)session.get(Book.class, BookID);
//            session.delete(Book);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
//}