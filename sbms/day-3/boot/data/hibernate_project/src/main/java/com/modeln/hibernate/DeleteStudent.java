package com.modeln.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.modeln.hibernate.entity.Student;
import com.modeln.hibernate.utils.HibernateUtils;

public class DeleteStudent {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		/*
		//--- delete student - Approach-1
		Student st = new Student(101, "Pankaj Kumar", "pankaj@hotmail.com");
		session.delete(st);
		*/
		
		//--- delete student - Approach-2
		
		int sid = 102;
		
		Student st = session.get(Student.class, sid);
		
		if(st != null) {
			System.out.println(st);
			
			Scanner sc = new Scanner(System.in);
			System.out.print("do you want to delete above student [Y/N]: ");
			String req = sc.next();
			
			if(req.equalsIgnoreCase("Y"))
				session.delete(st);
		}
		else
			System.out.println("no matching student found!!!");
		
		session.getTransaction().commit();
		
		session.close();
		sf.close();
	}

}
