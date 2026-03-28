package com.mphasis.firsthibernateapp;

import org.hibernate.Session;

import com.mphasis.firsthibernateapp.model.Contact;
import com.mphasis.firsthibernateapp.util.HibernateUtil;

public class L1CaheDemo {
    public static void main(String[] args) {
//    	 SingleSesion();
    	MultipleSesion();
}
    
    public static void SingleSesion() {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        
        
        s.beginTransaction();
        Contact c=s.find(Contact.class,"C2");
        System.out.println(c.getId()+","+c.getName()+","+c.getEmail());
        System.out.println("------------------------------------------------");
        c=s.find(Contact.class,"C2");
        System.out.println(c.getId()+","+c.getName()+","+c.getEmail());
        s.getTransaction().commit();
        s.close();
    }
    
    public static void MultipleSesion() {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Contact c=s.find(Contact.class,"C2");
        System.out.println(c.getId()+","+c.getName()+","+c.getEmail());
      s.getTransaction().commit();
      s.close();
      
      System.out.println("=================================================");
      s = HibernateUtil.getSessionFactory().getCurrentSession();
      s.beginTransaction();
     c=s.find(Contact.class,"C2");
      System.out.println(c.getId()+","+c.getName()+","+c.getEmail());
    s.getTransaction().commit();
    s.close();
    
    }


}