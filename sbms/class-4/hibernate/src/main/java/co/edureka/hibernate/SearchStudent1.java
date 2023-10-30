package co.edureka.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edureka.hibernate.entity.Student;
import co.edureka.hibernate.utils.HibernateUtils;

public class SearchStudent1 {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtils.getSessionFactory();
		Session session = sfactory.openSession();
		
		Student st = new Student();
		System.out.println(st);
		
		//int sid = 101;
		int sid = 1015;
		try {
			session.load(st, sid);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		System.out.println(st);
		
		session.close();
		sfactory.close();
	}
}
