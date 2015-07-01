package Library.dao;

import Library.entities.Book;
import Library.entities.Page;
import Library.utils.HibernateUtil;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

public class PageDAOImpl extends GenericDAOImpl<Page, Long> implements GenericDAO<Page, Long> {

    public PageDAOImpl() {
        super.setSessionFactory(HibernateUtil.getSessionFactory());

    }
}
