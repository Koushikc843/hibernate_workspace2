package com.mphasis.firsthibernateapp;

import com.mphasis.firsthibernateapp.contactDAO.EmployeeDAO;
import com.mphasis.firsthibernateapp.model.Department;

public class AppEmployeeDepartment {
   
	
	public static void main(String args[]) {
		
		EmployeeDAO edo=new EmployeeDAO();
	  Department d=new Department("D1","sales");
	  edo.addDepartment(d);
	}
}
