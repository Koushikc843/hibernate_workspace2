package com.mphasis.firsthibernateapp.contactDAO;

import org.hibernate.Session;

import com.mphasis.firsthibernateapp.model.Department;
import com.mphasis.firsthibernateapp.model.Employee;
import com.mphasis.firsthibernateapp.util.HibernateUtil;

public class EmployeeDAO {

	
	public boolean addEmployee(Employee e) {
		 Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	        s.beginTransaction();
	        s.persist(e);
	        s.getTransaction().commit();       
	        s.close();
return true;
	        
	}
	public boolean addDepartment(Department d) {
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        
        s.persist(d);
        s.getTransaction().commit();       
        s.close();
		return true;
	}
	public boolean assign(String empid,String deptid) {
	
		    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		    s.beginTransaction();
		    Employee e = s.get(Employee.class, empid);
		    Department d = s.get(Department.class, deptid);

//		    if (e == null || d == null) {
//		        s.getTransaction().commit();
//		        return false;
//		    }

		    e.setDepartment(d);  

		    s.persist(e);

		    s.getTransaction().commit();
		    s.close();

		    return true;
		}
	}

