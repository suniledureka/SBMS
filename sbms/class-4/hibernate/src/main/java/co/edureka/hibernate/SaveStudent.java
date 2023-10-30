package co.edureka.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import co.edureka.hibernate.entity.Student;

public class SaveStudent {

	public static void main(String[] args) {
		Configuration config = new Configuration(); 
		config.configure("hibernate.cfg.xml"); //XML Parsing takes place (DOM Parser)
		
		SessionFactory sfactory = config.buildSessionFactory();
		Session session = sfactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Student stud = new Student();
		stud.setStudentId(101);
		stud.setStudentName("Hasan");
		stud.setStudentEmail("hasan@gmail.com");
		
		session.save(stud);
		
		System.out.println("-----------------------------------------------------------------------");
		tx.commit();
		
		session.close();
		sfactory.close();
	}

}
