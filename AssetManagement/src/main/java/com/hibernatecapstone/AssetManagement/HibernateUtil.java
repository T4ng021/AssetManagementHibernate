package com.hibernatecapstone.AssetManagement;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	
	static {
		
			try{
			
					Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
					
					sessionFactory = cfg.buildSessionFactory();
				}
				catch(Throwable ex) {
					throw new ExceptionInInitializerError(ex);
				}
		}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
