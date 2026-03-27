package com.mphasis.firsthibernateapp.contactDAO;

import org.hibernate.Session;

import com.mphasis.firsthibernateapp.model.BlogPost;
import com.mphasis.firsthibernateapp.model.Comment;
import com.mphasis.firsthibernateapp.model.Department;
import com.mphasis.firsthibernateapp.model.Employee;
import com.mphasis.firsthibernateapp.util.HibernateUtil;

public class BlogPostDAO {

	public boolean addBlog(BlogPost b) {
		 Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	        s.beginTransaction();
	        s.persist(b);
	        s.getTransaction().commit();       
	        s.close();
	        System.out.println(b.getId()+"saved...");
		return true;
		
	}
	public boolean addComment(String blogid,Comment c) {
		 Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	        s.beginTransaction();
	        BlogPost bb = s.find(BlogPost.class, blogid);
	        bb.getComments().add(c);
	        s.persist(bb);
	        s.getTransaction().commit();       
	        s.close();
		return true;
	}
	
}
