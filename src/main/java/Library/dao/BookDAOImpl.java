package Library.dao;

import Library.utils.HibernateUtil;
import Library.entities.Book;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

public class BookDAOImpl extends GenericDAOImpl<Book, Long> implements GenericDAO<Book, Long> {

    public BookDAOImpl() {
        super.setSessionFactory(HibernateUtil.getSessionFactory());

    }
}
