package Library.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Library {

    @Id
    @GeneratedValue
    @Column(name = "LIBRARY_ID")
    private int id;

    private String name;
    private String city;
    private String street;
    private String postCode;


    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<Employee>();

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
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


    public String getName() {
        return name;
    }
}
