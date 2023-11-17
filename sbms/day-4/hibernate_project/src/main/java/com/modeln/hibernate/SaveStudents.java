package com.modeln.hibernate;

import java.io.Serializable;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.modeln.hibernate.entity.Student;
import com.modeln.hibernate.utils.HibernateUtils;

public class SaveStudents {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtils.getSessionFactory();
		Session session = sfactory.openSession();
		
		Transaction tx = session.beginTransaction();		
		
		String req = "Y";
		
		do {
			Student st = getStudent();
			//session.save(st);
			Serializable sid = session.save(st);
			System.out.printf("student with student id: %d\n saved", sid);
			
			System.out.print("do you want to save more students[Y/N]: ");
			req = sc.next();
		}while(req.equalsIgnoreCase("Y"));
		
		System.out.println("----------------------------------------------------------------------");
		tx.commit();
		
		session.close();
		sfactory.close();
	}

	private static Student getStudent() {
		System.out.println("enter student name & email: ");
		String name = sc.next();
		String email = sc.next();
		
		return new Student(name, email);
	}
}