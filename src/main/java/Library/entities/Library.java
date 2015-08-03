package Library.entities;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity @Data
public class Library extends DB_Object {

    @Id
    @GeneratedValue
    @Column(name = "LIBRARY_ID")
    private int id;

    private String name;
    private String city;
    private String street;
    private String postCode;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "library", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Employee> employees = new ArrayList<Employee>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "library", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Book> books = new ArrayList<Book>();

    public Library(String name, String postCode, String street, String city) {
        this.name = name;

        this.postCode = postCode;
        this.street = street;
        this.city = city;
    }

    public Library() {
    }

    public void addBook(Book book) {
        book.setLibrary(this);
        books.add(book);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }


//    @Override
//    public String toString() {
//        return "Library{";
//    }
}
