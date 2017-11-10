package com.springproject.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.dao.CustomerOrderDao;
import com.springproject.entity.CustomerOrder;
import com.springproject.entity.Product;

@Repository
public class CustomerOrderDaoImpl implements CustomerOrderDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void addCustomerOrder(CustomerOrder customerOrder) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		//save the customerOrder
		currentSession.save(customerOrder);
	}
	


}
