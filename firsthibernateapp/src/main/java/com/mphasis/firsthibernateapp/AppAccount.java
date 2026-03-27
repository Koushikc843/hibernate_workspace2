
	package com.mphasis.firsthibernateapp;
	import org.hibernate.Session;

	import com.mphasis.firsthibernateapp.model.creditaccount;
import com.mphasis.firsthibernateapp.model.debitaccount;
import com.mphasis.firsthibernateapp.util.HibernateUtil;
	public class AppAccount{

		public static void main(String args[])
		{
			   Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			    session.beginTransaction();
		creditaccount tw=new creditaccount();
		tw.setId("C1");
		tw.setCreditLimit(100000);
		tw.setBalance(500000);
		session.persist(tw);

		debitaccount Fw=new debitaccount();
		Fw.setId("D1");
		Fw.setOverdraftFeet(1000);
		Fw.setBalance(600000);
		session.persist(Fw);
		
		

		session.getTransaction().commit();
	session.close();
	}
	}

