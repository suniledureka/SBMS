package co.edureka.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import co.edureka.hibernate.entity.Student;
import co.edureka.hibernate.utils.HibernateUtils;

public class HQLTest {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtils.getSessionFactory();
		Session session = sfactory.openSession();
		
		//String hql = "from co.edureka.hibernate.entity.Student";
		//String hql = "from co.edureka.hibernate.entity.Student where studentName='HASAN'";
		//String hql = "from co.edureka.hibernate.entity.Student where studentName like 'S%'";
		//String hql = "from co.edureka.hibernate.entity.Student where studentId in (105,101,402,205,106)";
		/*
		Query<Student> q = session.createQuery(hql, Student.class);
		List<Student> students = q.getResultList();
		*/
		
		/*
		String hql = "from co.edureka.hibernate.entity.Student where studentId between ?0 and ?1"; //positional parameters
		Query<Student> q = session.createQuery(hql, Student.class);
		q.setParameter(0, 101);
		q.setParameter(1, 105);
		*/
		
		String hql = "from co.edureka.hibernate.entity.Student where studentId between :minsid and :maxsid"; //named parameters
		Query<Student> q = session.createQuery(hql, Student.class);
		q.setParameter("minsid", 101);
		q.setParameter("maxsid", 250);
		
		List<Student> students = q.getResultList();
		
		//printStudents(students);
		
		//-- performing DML (update) operation with HQL
		session.beginTransaction();
		hql = "update co.edureka.hibernate.entity.Student set studentName='Abdul Khadar', studentEmail='khadar@gmail.com' where "
				+ "studentId=109";
		
		Query query = session.createQuery(hql);
		int rowsAffected = query.executeUpdate();
		System.out.println("students updated = " + rowsAffected);
		session.getTransaction().commit();
		
		session.close();
		sfactory.close();
	}

	private static void printStudents(List<Student> students) {
		for(Student st : students) {
			System.out.println(st);
			try {
				Thread.sleep(1000);
			}catch(Exception ex) {}
		}
	}

}
