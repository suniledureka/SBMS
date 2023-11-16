package com.modeln.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.modeln.hibernate.entity.Student;
import com.modeln.hibernate.utils.HibernateUtils;

public class HQLTest {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		
		//String hql = "from com.modeln.hibernate.entity.Student";
		//String hql = "from com.modeln.hibernate.entity.Student where studentName LIKE 'C%'";
		String hql = "from com.modeln.hibernate.entity.Student where studentId IN (101,102,302,104)";
		Query<Student> q = session.createQuery(hql, Student.class);
		
		List<Student> studs = q.getResultList();
		printStudents(studs);
		
		session.close();
		sf.close();

	}

	private static void printStudents(List<Student> studs) {
		studs.stream().forEach(System.out::println);
		//studs.stream().forEach(st -> System.out.println(st));
	}

}
