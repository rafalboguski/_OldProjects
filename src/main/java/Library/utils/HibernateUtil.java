package Library.utils;

import Library.dao.BookDAOImpl;
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

    private static final BookDAOImpl dao = new BookDAOImpl();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public static BookDAOImpl Book() {
        return dao;
    }
}
