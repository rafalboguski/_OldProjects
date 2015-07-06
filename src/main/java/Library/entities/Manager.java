package Library.entities;

import javax.persistence.*;


@Entity
@DiscriminatorValue("Manager")
public class Manager extends Employee {

    private String manager_salary;

    public Manager(String name, String surname, String bankAccountNumber, String manager_salary) {
        super(name, surname, bankAccountNumber);
        this.manager_salary = manager_salary;
    }


    public Manager() {
    }
}
