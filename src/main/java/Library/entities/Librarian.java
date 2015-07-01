package Library.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Librarian")
public class Librarian extends Employee {


}
