package Library.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    private int id;

    private String name;
    private String surname;
    private boolean suspended;
    private int telephone;
    private Date registrationDate;

    @OneToMany(mappedBy = "owner")
    private List<Book> books;


}
