package com.modeln.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.modeln.hibernate.entity.Student;
import com.modeln.hibernate.utils.HibernateUtils;

public class UpdateStudent {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		/*
		//--- updating student - Approach-1
		Student st = new Student(101, "Pankaj Kumar", "pankaj@hotmail.com");
		session.update(st);
		*/
		
		//--- updating student - Approach-2
		
		int sid = 102;
		
		Student st = session.get(Student.class, sid);
		
		if(st != null) {
			System.out.println(st);
			st.setStudentName("Sanjay Patil"); //dirty object
		}
		else
			System.out.println("no matching student found!!!");
		
		session.getTransaction().commit();
		
		session.close();
		sf.close();
	}

}
