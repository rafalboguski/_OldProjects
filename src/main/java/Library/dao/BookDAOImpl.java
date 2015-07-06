package Library.dao;

import Library.entities.Library;
import Library.utils.HibernateUtil;
import Library.entities.Book;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.Search;

public class BookDAOImpl extends GenericDAOImpl<Book, Long> implements GenericDAO<Book, Long> {

    public BookDAOImpl() {
        super.setSessionFactory(HibernateUtil.getSessionFactory());

    }

    public void moveBookTOLibrary(Book book, Library newLibrary) {

        book.getLibrary().removeBook(book);
        newLibrary.addBook(book);
        HibernateUtil.Library().save(newLibrary);

    }

    public Book find(String title) {

        Search s = new Search();
        s.addFilterEqual("title", title);


        return (Book) this.search(s).get(0);
    }

}
