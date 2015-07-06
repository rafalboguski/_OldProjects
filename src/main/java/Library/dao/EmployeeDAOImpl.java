package Library.dao;

import Library.entities.Book;
import Library.entities.Employee;
import Library.utils.HibernateUtil;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

public class EmployeeDAOImpl extends GenericDAOImpl<Employee, Long> implements GenericDAO<Employee, Long> {

    public EmployeeDAOImpl() {
        super.setSessionFactory(HibernateUtil.getSessionFactory());

    }
}
