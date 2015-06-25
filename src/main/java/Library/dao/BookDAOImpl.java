package Library.dao;

import Library.HibernateUtil;
import Library.dao.BookDAO;
import Library.entities.Book;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

public class BookDAOImpl extends GenericDAOImpl<Book, Long> implements BookDAO {

    public BookDAOImpl() {
        super.setSessionFactory(HibernateUtil.getSessionFactory());

    }
}
