package Library.utils;


import com.mysema.query.hql.hibernate.HibernateQuery;
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




    public static Session db(){
        return sessionFactory.getCurrentSession();
    }

    public static void dbBegin(){
        sessionFactory.getCurrentSession().beginTransaction();
    }

    public static void dbEnd(){
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    // QueryDsl

    public static HibernateQuery query(){
        return new HibernateQuery(db());
    }

}
