package co.edureka.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.edureka.hibernate.entity.Student;
import co.edureka.hibernate.utils.HibernateUtils;

public class DeleteStudent {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtils.getSessionFactory();
		Session session = sfactory.openSession();
		session.beginTransaction();
		
		/*
		//--- deleting an entity - approach-1 ---
		Student st = new Student(101, "HASAN", "hasan@edureka.co");
		session.delete(st);
		*/
		
		//--- deleting an entity - approach-2 ---
		int sid = 108;
		Student st = session.get(Student.class, sid);
		if(st != null) {
			System.out.println(st);
			session.delete(st);
		}
		else
			System.out.println("###--- no matching student found with SID: " + sid + " ---###");
		
		session.getTransaction().commit();
		session.close();
		sfactory.close();
	}

}
