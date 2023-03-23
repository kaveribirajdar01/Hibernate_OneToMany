package comp.Anudip.OneToMany_Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Course c=new Course();
    	c.setC_Id(101);
    	c.setCourse_Name("Java");
    	Course c1=new Course();
    	c1.setC_Id(102);
    	c1.setCourse_Name("Python");
    	Course c2=new Course();
    	c2.setC_Id(103);
    	c2.setCourse_Name("C");
    	
    	Teacher tr=new Teacher();
    	tr.setId(101);
    	tr.setName("Mrunali");
    	tr.getList1().add(c);
    	tr.getList1().add(c1);
    	tr.getList1().add(c2);

    	
    	Configuration cfg=new Configuration().configure().addAnnotatedClass(Teacher.class).addAnnotatedClass(Course.class);
    	SessionFactory sf=cfg.buildSessionFactory();
    	Session s=sf.openSession();
    	Transaction t=s.beginTransaction();
    	s.save(c);
    	s.save(c1);
    	s.save(c2);
    	s.save(tr);
    	s.getTransaction().commit();
    	
        System.out.println( "Hello World!" );
    }
}
