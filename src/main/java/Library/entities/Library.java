package Library.entities;

import javax.persistence.*;
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


    @OneToMany(mappedBy = "library")
    private List<Employee> employees;

    @OneToMany(mappedBy = "library")
    private List<Book> books;

}
