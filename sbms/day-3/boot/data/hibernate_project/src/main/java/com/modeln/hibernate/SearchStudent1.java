package com.modeln.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.modeln.hibernate.entity.Student;
import com.modeln.hibernate.utils.HibernateUtils;

public class SearchStudent1 {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		
		Student st = new Student();
		System.out.println(st);
		
		try {
			int sid = 1015;
			session.load(st, sid);
		}catch(Exception ex) {
			System.err.println(ex.toString());
		}
		
		System.out.println(st);
		
		session.close();
		sf.close();
	}

}
