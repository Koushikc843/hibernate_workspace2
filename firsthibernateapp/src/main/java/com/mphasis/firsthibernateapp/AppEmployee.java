package com.mphasis.firsthibernateapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mphasis.firsthibernateapp.model.Address;
import com.mphasis.firsthibernateapp.model.Customer;
import com.mphasis.firsthibernateapp.model.Department;
import com.mphasis.firsthibernateapp.model.Employee;
import com.mphasis.firsthibernateapp.model.Locker;
import com.mphasis.firsthibernateapp.model.User;
import com.mphasis.firsthibernateapp.util.HibernateUtil;

public class AppEmployee {

    public static void main(String[] args) {

        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();

      Department d=new Department("D1","Sales");
      
        s.persist(d);
      Employee e=new Employee("E1","Tom",200000);
     e.setDepartment();
        s.persist(e);
      
s.getTransaction().commit();       
        s.close();
       

        System.out.println("saved");
    }
}