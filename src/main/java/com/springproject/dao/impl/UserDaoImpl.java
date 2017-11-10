package com.springproject.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.dao.UserDao;
import com.springproject.entity.Customer;
import com.springproject.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public User getUserByName(String theUsername) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		
		Query theQuery = 
				currentSession.createQuery("from User where username=:theUsername");
		theQuery.setParameter("theUsername", theUsername);
       
		
		return (User) theQuery.uniqueResult();
		
	}

}
