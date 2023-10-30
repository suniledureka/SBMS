package co.edureka.hibernate;

import java.io.Serializable;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import co.edureka.hibernate.entity.Student;
import co.edureka.hibernate.utils.HibernateUtils;

public class SaveStudents {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtils.getSessionFactory();
		Session session = sfactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Scanner sc = new Scanner(System.in);
		
		String req = "Y";
		do {
			System.out.print("enter student name: ");
			String name = sc.next();
			
			System.out.print("enter student email: ");
			String email = sc.next();
			
			Student st = new Student(name, email);
			Serializable sid = session.save(st);
			System.out.println("Student saved with Student ID: " + sid);
			
			System.out.print("do you want to add more students?[Y/N]: ");
			req = sc.next();
		}while(req.equalsIgnoreCase("Y"));
		
		tx.commit();
		sc.close();
		session.close();
		sfactory.close();
	}

}
