package Library.entities;

import lombok.Data;

import javax.persistence.*;


@Entity @Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "EMPLOYEE_TYPE", discriminatorType = DiscriminatorType.STRING)

public class Employee {

    @Id
    @GeneratedValue()
    private int id;

    private String name;
    private String surname;
    private String bankAccountNumber;
    private boolean active;


    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID")
    private Library library;

    public Employee(String name, String surname, String bankAccountNumber) {
        this.name = name;
        this.surname = surname;
        this.bankAccountNumber = bankAccountNumber;
        this.active = true;
    }

    public Employee() {
    }




}
