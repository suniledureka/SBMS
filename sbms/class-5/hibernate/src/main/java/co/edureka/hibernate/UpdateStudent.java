package co.edureka.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.edureka.hibernate.entity.Student;
import co.edureka.hibernate.utils.HibernateUtils;

public class UpdateStudent {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtils.getSessionFactory();
		Session session = sfactory.openSession();
		Transaction tx = session.beginTransaction();
		
		/*
		//--- updating an entity - approach-1 ---
		Student st = new Student(101, "HASAN", "hasan@edureka.co");
		session.update(st);
		*/
		
		//--- updating an entity - approach-2 ---
		int sid = 102;
		Student st = session.get(Student.class, sid);
		if(st != null) {
			System.out.println(st);
			st.setStudentName("Sunil Joseph"); //dirty object
		}
		else
			System.out.println("###--- no matching student fund with SID: " + sid + " ---###");
		
		tx.commit();
		session.close();
		sfactory.close();
	}

}
