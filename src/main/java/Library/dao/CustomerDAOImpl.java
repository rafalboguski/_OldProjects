package Library.dao;

import Library.entities.Book;
import Library.entities.Customer;
import Library.utils.HibernateUtil;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

public class CustomerDAOImpl extends GenericDAOImpl<Customer, Long> implements GenericDAO<Customer, Long> {

    public CustomerDAOImpl() {
        super.setSessionFactory(HibernateUtil.getSessionFactory());

    }
}
