package Library.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity @Data
public class Customer extends DB_Object {

    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private boolean suspended;

    @Column(nullable = false)
    private String telephone;

    @Column(nullable = false)
    private Date registrationDate;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<Book>();

    public Customer(String name, String surname, String telephone) {
        this.name = name;
        this.surname = surname;
        this.suspended = false;
        this.telephone = telephone;
        this.registrationDate = new Date();
    }

    public Customer() {
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);

    }


}
