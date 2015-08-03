package Library.utils;

import Library.utils.HibernateUtil;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        HibernateUtil.getCurrentSession().getTransaction().rollback();
        System.err.println("Exception: Rollback last data base transaction:\n"
                + e);

    }
}