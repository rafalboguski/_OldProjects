package Library.entities;

import javax.persistence.*;


@Entity
@DiscriminatorValue("Manager")
public class Manager extends Employee {

    private String manager_salary;


}
