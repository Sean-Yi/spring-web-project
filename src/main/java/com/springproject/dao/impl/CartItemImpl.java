package com.springproject.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.dao.CartItemDao;
import com.springproject.entity.Cart;
import com.springproject.entity.CartItem;
import com.springproject.entity.Product;

@Repository
public class CartItemImpl implements CartItemDao {
	
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
	public void updateCartItem(CartItem theCartItem) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save or update the object
		currentSession.update(theCartItem);
	}
    
    @Transactional
	public void addCartItem(CartItem theCartItem) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save or update the object
		currentSession.save(theCartItem);
	}

    @Transactional
	public void removeCartItem(CartItem cartItem) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete object with object
		currentSession.delete(cartItem);

	}
    
    @Transactional
	public void removeAllCartItems(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems) {
            removeCartItem(item);
        }

	}
    
    @Transactional
	public void removeCartItem(int theCartItemId) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = 
				currentSession.createQuery("delete from CartItem where id=:theCartItemId");
		theQuery.setParameter("theCartItemId", theCartItemId);
		
		theQuery.executeUpdate();

	}
	
    @Transactional
	public CartItem getCartItemByProductId(int theProductId, int theCartId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = 
				currentSession.createQuery("from CartItem where product="+theProductId+" and cart="+theCartId);
		//theQuery.setParameter("theProductId", theProductId);

        return (CartItem) theQuery.uniqueResult();
        
	}
    
    
    @Transactional
	public CartItem getCartItemBycartId(int theCartItemId) {
		//get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		//retrieve from database using the primary key
		CartItem theCartItem = currentSession.get(CartItem.class, theCartItemId);

		return theCartItem;
	}
    

}
