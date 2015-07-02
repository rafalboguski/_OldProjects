package OneToMany;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

public class Manage {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        SessionFactory factory;
        try{
            factory = new AnnotationConfiguration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Session session = factory.openSession();
        session.beginTransaction();

        Department department = new Department();
        department.setDepartmentName("Sales");
        session.save(department);

        Employee emp1 = new Employee("a", "aa", "111");
        Employee emp2 = new Employee("b", "bb", "222");

        emp1.setDepartment(department);
        emp2.setDepartment(department);

        session.save(emp1);
        session.save(emp2);

        session.getTransaction().commit();

        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Employee").list();
            tx.commit();
            System.out.println("List Employees {");
            for (Employee emp:(List<Employee>)employees){
                System.out.print("  {FirstName: " + emp.getFirstname());
                System.out.print("  LastName: " + emp.getLastname());
                System.out.println("  Department: " + emp.getDepartment().getDepartmentName()+"},");
            }
            System.out.println("}");

        }catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }


        session.close();
    }



}