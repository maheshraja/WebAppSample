package com.yogesh.webapp.db.util;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.yogesh.webapp.model.Flight;
import com.yogesh.webapp.model.User;


public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory==null)
		{
			try {
				Configuration config = new Configuration();
				
				Properties props = new Properties();
				props.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				props.put(Environment.URL, "jdbc:mysql://localhost:3306/bookingDB?useSSL=false");
				props.put(Environment.USER, "root");
				props.put(Environment.PASS, "root");
				props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
				props.put(Environment.SHOW_SQL, "true");
				props.put(Environment.FORMAT_SQL, "true");
				
				
				props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				//This line will create the schema in the database
				props.put(Environment.HBM2DDL_AUTO, "update");
				
				config.setProperties(props);
				

				config.addAnnotatedClass(Flight.class);
				config.addAnnotatedClass(User.class);
				
				ServiceRegistry serviceregistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
				
				System.out.println("Hibernate Java Config service Registry created");
				
				sessionFactory=config.buildSessionFactory(serviceregistry);
			} catch (HibernateException e) {
				e.printStackTrace();
			}

		}
		return sessionFactory;
	}
	
	public static void main(String[] args) {
		Session session = getSessionFactory().openSession();
	}
}
