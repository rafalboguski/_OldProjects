package Library.entities;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "EMPLOYEE_TYPE", discriminatorType = DiscriminatorType.STRING)

public class Employee {

    @Id
    @GeneratedValue()
    private int id;

    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID")
    private Library library;


}
