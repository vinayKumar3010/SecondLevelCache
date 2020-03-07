package org.com.xworkz.Tester;

import org.com.xworkz.SecondLevel.Secondlevel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TesterClass {

	public static void main(String args[]) {

		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Secondlevel sl1 = (Secondlevel) session.load(Secondlevel.class, 2);
	    System.out.println("Details 1: "+sl1.getId() + " " + sl1.getName() + " " + sl1.getAge());
		session.getTransaction().commit();
		session.close();
		
		

		Session session2 = factory.openSession();
		session2.beginTransaction();
		//Since we enabled the second level cache in xml, 
		//it will look in "second level cache" instead of hitting DB server
		//and display the data from SecondLevelCache.
		Secondlevel sl2 = (Secondlevel) session2.load(Secondlevel.class, 2);
		System.out.println("Details 2: "+sl2.getId() + " " + sl2.getName() + " " + sl2.getAge());
		session2.getTransaction().commit();
		session2.close();

		
	}

}
