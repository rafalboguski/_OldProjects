package Library.utils;

import Library.dao.BookDAOImpl;
import Library.dao.CustomerDAOImpl;
import Library.dao.EmployeeDAOImpl;
import Library.dao.LibraryDAOImpl;
import Library.entities.Employee;
import Library.entities.Library;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtil {


    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed\n" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static final BookDAOImpl     bookDAO     = new BookDAOImpl();
    public static final CustomerDAOImpl customerDAO = new CustomerDAOImpl();
    public static final LibraryDAOImpl  libraryDAO  = new LibraryDAOImpl();
    public static final EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();


    //----------------------------------------------------------------------------

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


}
