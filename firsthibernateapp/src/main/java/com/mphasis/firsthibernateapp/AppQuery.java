package com.mphasis.firsthibernateapp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import com.mphasis.firsthibernateapp.model.BlogPost;
import com.mphasis.firsthibernateapp.model.Contact;
import com.mphasis.firsthibernateapp.model.Department;
import com.mphasis.firsthibernateapp.util.HibernateUtil;
import com.mphasis.firsthibernateapp.model.User;

public class AppQuery {
	public static void main(String args[]) {
		// simple();
//		param();
//		 agg_count();
//		lazy();
		namedquery();
	}

	private static void simple() {
		// Create initial data
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		SelectionQuery<Contact> q = s.createSelectionQuery("FROM Contact", Contact.class);
		List<Contact> contacts = q.getResultList();
		for (Contact contact : contacts) {
			System.out.println(contact.getId() + "," + contact.getName() + "," + contact.getEmail());
		}
		s.getTransaction().commit();
		s.close();

	}

	private static void param() {
		// Create initial data
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		SelectionQuery<Contact> q = s.createSelectionQuery("FROM Contact c where c.id=:id", Contact.class);
		q.setParameter("id", "c2");
		Contact c = q.getSingleResult();
		System.out.println(c.getId() + "," + c.getName() + "," + c.getEmail());

		s.getTransaction().commit();
		s.close();

	}

	private static void agg_count() {
		// Create initial data
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		SelectionQuery<Long> q = s.createSelectionQuery("select count(c.id) from Contact c", Long.class);

		Long count = q.getSingleResult();
		System.out.println("count=" + count);

		s.getTransaction().commit();
		s.close();

	}

	private static void lazy() {
		// Create initial data
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		SelectionQuery<BlogPost> q = s.createSelectionQuery(" FROM BlogPost d WHERE d.id = :id ", BlogPost.class);
		q.setParameter("id", "B1");
		BlogPost dt = q.getSingleResult();
		System.out.println(dt.getId() + "," + dt.getTitle() + "," + dt.getAuthor());
		System.out.println(dt.getComments());

		s.getTransaction().commit();
		s.close();

	}

	private static void namedquery() {
		// Create initial data
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		SelectionQuery<User> q = s.createNamedSelectionQuery("findAll", User.class);
		List<User> u = q.getResultList();
		for (User user : u) {
			System.out.println(user.getId() + "," + user.getName() + "," + user.getAddress().getCity());
		}

		s.getTransaction().commit();
		s.close();

	}

}
