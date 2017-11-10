package com.springproject.dao;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.entity.Cart;
import com.springproject.entity.CartItem;

public interface CartItemDao {
    
	void updateCartItem(CartItem theCartItem);
	
    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);
    
    void removeCartItem(int cartItemId);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId (int productId, int theCartId);
    
    public CartItem getCartItemBycartId(int theCartItemId);
}
