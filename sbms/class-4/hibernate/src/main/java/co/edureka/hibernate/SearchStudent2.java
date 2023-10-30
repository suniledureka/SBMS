package co.edureka.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edureka.hibernate.entity.Student;
import co.edureka.hibernate.utils.HibernateUtils;

public class SearchStudent2 {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtils.getSessionFactory();
		Session session = sfactory.openSession();
		
		//int sid = 101;
		int sid = 1015;
		
		Student st = session.get(Student.class, sid);
		if(st != null)
			System.out.println(st);
		else
			System.out.println("###--- no matching student fund with SID: " + sid + " ---###");
		
		session.close();
		sfactory.close();
	}

}
