package com.springproject.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.dao.ProductDao;
import com.springproject.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Product> getProducts() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Product> theQuery = currentSession.createQuery("from Product", Product.class);
		
		// execute query and get result list
		List<Product> products = theQuery.getResultList();
				
		// return the results		
		return products;
	}
	
	@Transactional
	public void saveProduct(Product theProduct) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		/*
		//save the Product
		currentSession.save(theProduct);
		*/
		
		/*
		//update the Product
		currentSession.update(theProduct);
		*/
		
		//save or update the Product
		currentSession.saveOrUpdate(theProduct);

	}
	
	@Transactional
	public Product getProduct(int theProductId) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		//retrieve from database using the primary key
		Product theProduct = currentSession.get(Product.class, theProductId);

		return theProduct;
	}
	
	@Transactional
	public void deleteProduct(int theProductId) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Product where id=:theProductId");
		theQuery.setParameter("theProductId", theProductId);
		
		theQuery.executeUpdate();

	}

}
