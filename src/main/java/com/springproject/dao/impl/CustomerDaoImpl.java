package com.springproject.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.springproject.dao.CustomerDao;
import com.springproject.entity.*;


@Repository
public class CustomerDaoImpl implements CustomerDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}
	
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//set customer enable
		theCustomer.setEnabled(true);
		
		//create cart
        Cart newCart = new Cart();
        newCart.setCustomer(theCustomer);
        currentSession.saveOrUpdate(newCart);

		//mapping object
        theCustomer.getBillingAddress().setCustomer(theCustomer);
        theCustomer.getShippingAddress().setCustomer(theCustomer);
        theCustomer.setCart(newCart); 

        //save or update the Customer
        currentSession.saveOrUpdate(theCustomer);
        
        //save or update the BillingAddress
        currentSession.saveOrUpdate(theCustomer.getBillingAddress());

        //save or update the ShippingAddress
        currentSession.saveOrUpdate(theCustomer.getShippingAddress());
     
        //Create user
        User newUser = new User();
        newUser.setUsername(theCustomer.getUsername());
        newUser.setPassword(theCustomer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerId(theCustomer);
        currentSession.saveOrUpdate(newUser);

        //create Authorities
        Authorities newAuthority = new Authorities();
        newAuthority.setUsername(theCustomer.getUsername());
        newAuthority.setAuthority("ROLE_USER");
        currentSession.saveOrUpdate(newAuthority);

	}
	
	@Transactional
	public Customer getCustomer(int theCustomerId) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		//retrieve from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theCustomerId);

		return theCustomer;
	}
	
	@Transactional
	public Customer getCustomerByname(String theCustomerName) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

	
		Query theQuery = 
				currentSession.createQuery("from Customer where username=:theCustomerName");
		theQuery.setParameter("theCustomerName", theCustomerName);
        
		return (Customer) theQuery.uniqueResult();
	}

	@Transactional
	public void deleteCustomer(int theCustomerId) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Customer where id=:theCustomerId");
		theQuery.setParameter("theCustomerId", theCustomerId);
		
		theQuery.executeUpdate();
	}
	

}
