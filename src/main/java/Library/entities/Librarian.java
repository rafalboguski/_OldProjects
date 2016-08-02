package Library.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Librarian")
public class Librarian extends Employee {

    public Librarian() {
    }

    public Librarian(String name, String surname, String bankAccountNumber) {

        super(name, surname, bankAccountNumber);
    }
}
