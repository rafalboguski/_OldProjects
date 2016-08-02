package Library.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("Janitor")
public class Janitor extends Employee {


}
