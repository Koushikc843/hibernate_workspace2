package com.mphasis.firsthibernateapp;
import org.hibernate.Session;

import com.mphasis.firsthibernateapp.contactDAO.BlogPostDAO;
import com.mphasis.firsthibernateapp.model.BlogPost;
import com.mphasis.firsthibernateapp.model.Comment;
import com.mphasis.firsthibernateapp.util.HibernateUtil;
public class AppBlogComment {

	

	    public static void main(String[] args) {
//save(){
	testblog();
}
   private static void save() { 
	        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	        s.beginTransaction();
	    
	        BlogPost b  = new   BlogPost("B1", "spring AI", "Spring AI is an application framework. "+"intelligence into enterprise ."
	        +" Java application." ,"Josh Long");
	        
	        Comment c1=new Comment("C1","Nice!!","Tom");
	        Comment c2=new Comment("C2","Good!!","Sam");
	        c1.setBlogpost(b);
	        c2.setBlogpost(b);
	        b.getComments().add(c1);
	        b.getComments().add(c2);
	        s.persist(b);
	      s.getTransaction().commit();
	        System.out.println("saved");
	    }
	    
	    private static void testblog()
	{
	    	  BlogPostDAO blogpostDAO=new BlogPostDAO();
		        BlogPost blog  = new   BlogPost("B2", "spring kk", "Spring AI is an application framework. "+"intelligence into enterprise ."
		    	        +" Java application." ,"Josh Long");
		         blogpostDAO.addBlog(blog);
		         Comment comment=new Comment("C3","Nice!!","kou");
			   blogpostDAO.addComment("B2",comment);
	}
}

