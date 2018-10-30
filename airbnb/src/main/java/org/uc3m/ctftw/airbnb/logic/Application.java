package org.uc3m.ctftw.airbnb.logic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Application {
	static Session sessionObj;
	static SessionFactory sessionFactoryObj;
	
	public static SessionFactory buildSessionFactory() {
		// Creating Configuration Instance & Passing Hibernate Configuration File
		Configuration configObj = new Configuration();
		configObj.configure("/resources/hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build(); 

		// Creating Hibernate SessionFactory Instance
		sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return sessionFactoryObj;
	}
	
	public static void main(String[] args) {
		
		System.out.println(".......Hibernate Maven Example.......\n");
		try {
			sessionObj = buildSessionFactory().openSession();
			sessionObj.beginTransaction();

			for(int i = 101; i <= 105; i++) {
				
			}
			System.out.println("\n.......Records Saved Successfully To The Database.......\n");

			// Committing The Transactions To The Database
			sessionObj.getTransaction().commit();
		} catch(Exception sqlException) {
			if(null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if(sessionObj != null) {
				sessionObj.close();
			}
		}
	}
}
