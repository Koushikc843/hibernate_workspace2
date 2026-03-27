package com.mphasis.firsthibernateapp;
import org.hibernate.Session;

import com.mphasis.firsthibernateapp.model.Course;
import com.mphasis.firsthibernateapp.model.FourWheeler;
import com.mphasis.firsthibernateapp.model.Student;
import com.mphasis.firsthibernateapp.model.TwoWheeler;
import com.mphasis.firsthibernateapp.util.HibernateUtil;
public class AppVehicle {

	public static void main(String args[])
	{
		   Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		    session.beginTransaction();
	TwoWheeler tw=new TwoWheeler();
	tw.setId("V1");
	tw.setManufacturer("Honda");
	tw.setSteeringHandleType("T-Bar");
	session.persist(tw);

	FourWheeler Fw=new FourWheeler();
	Fw.setId("V2");
	Fw.setManufacturer("BMW");
	Fw.setSteeringHandleType("Power");
	session.persist(Fw);
	
	FourWheeler Fw1=new FourWheeler();
	Fw1.setId("V3");
	Fw1.setManufacturer("Mustung");
	Fw1.setSteeringHandleType("Power");
	session.persist(Fw1);
	
	TwoWheeler tw1=new TwoWheeler();
	tw1.setId("V4");
	tw1.setManufacturer("Ducati");
	tw1.setSteeringHandleType("T-Bar");
	session.persist(tw1);


	session.getTransaction().commit();
session.close();
}
}