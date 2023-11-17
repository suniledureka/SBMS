package com.modeln.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sfactory;
	
	public static SessionFactory getSessionFactory() {
		if(sfactory == null) {
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml"); //DOM Parser
				
			sfactory = config.buildSessionFactory();
		}
		return sfactory;
	}
}
