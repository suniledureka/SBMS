package co.edureka.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import co.edureka.hibernate.entity.Product;
import co.edureka.hibernate.entity.Student;
import co.edureka.hibernate.utils.HibernateUtils;

public class SaveProduct {

	public static void main(String[] args) {		
		SessionFactory sfactory = HibernateUtils.getSessionFactory();
		Session session = sfactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Product prod = new Product();
		prod.setProductId(10015);
		prod.setProductName("Mobile Phone");
		prod.setProductPrice(75000.5f);
		
		session.save(prod);
		
		System.out.println("-----------------------------------------------------------------------");
		tx.commit();
		
		session.close();
		sfactory.close();
	}

}
