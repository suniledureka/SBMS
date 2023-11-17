package com.modeln.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.modeln.hibernate.entity.Product;
import com.modeln.hibernate.entity.Student;
import com.modeln.hibernate.utils.HibernateUtils;

public class SaveProduct {

	public static void main(String[] args) {
		
		SessionFactory sfactory = HibernateUtils.getSessionFactory();
		Session session = sfactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Product prod = new Product();
		//prod.setProduId(101);
		prod.setProductName("Mobile Phone");
		prod.setProductPrice(65000.5f);
		
		session.save(prod);
		System.out.println("---------------------------------------------");
		
		tx.commit();
		
		
		session.close();
		sfactory.close();
	}

}
