package com.modeln.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.modeln.hibernate.entity.Student;
import com.modeln.hibernate.utils.HibernateUtils;

public class SearchStudent2 {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		
		//int sid = 101;
		int sid = 1015;
		
		Student st = session.get(Student.class, sid);
		
		if(st != null)
			System.out.println(st);
		else
			System.out.println("no matching student found!!!");
		
		session.close();
		sf.close();
	}

}
