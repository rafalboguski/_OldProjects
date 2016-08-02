package Library.entities;

import static Library.utils.HibernateUtil.*;


public abstract class DB_Object {

    public void save(){
        db().save(this);
    }

    public void destroy(){
        db().delete(this);
    }

}
