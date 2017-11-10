package com.springproject.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.dao.CartDao;
import com.springproject.entity.Cart;

@Repository
public class CartDaoImpl implements CartDao {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void create(Cart theCart) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
	
		//save the object
		currentSession.save(theCart);
	
	}
	
	@Transactional
	public Cart getCartById (int theCartId) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		//retrieve from database using the primary key
		Cart theCart = currentSession.get(Cart.class, theCartId);

		return theCart;
	}
	
	@Transactional
	public void update(Cart thecart) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
	
		//save the object
		currentSession.update(thecart);

	}
	
	@Transactional
	public void delete(int theCartId) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Cart where id=:theCartId");
		theQuery.setParameter("theCartId", theCartId);
		
		theQuery.executeUpdate();

	}

}
