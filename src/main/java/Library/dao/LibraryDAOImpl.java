package Library.dao;

import Library.entities.Book;
import Library.entities.Library;
import Library.utils.HibernateUtil;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.Search;

public class LibraryDAOImpl extends GenericDAOImpl<Library, Long> implements GenericDAO<Library, Long> {

    public LibraryDAOImpl() {
        super.setSessionFactory(HibernateUtil.getSessionFactory());
    }

    public Library find(String name) {

        Search s = new Search();
        s.addFilterEqual("name", name);

        return (Library) this.search(s).get(0);
    }
}
