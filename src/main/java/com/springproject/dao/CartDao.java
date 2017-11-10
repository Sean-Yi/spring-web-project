package com.springproject.dao;

import com.springproject.entity.Cart;

public interface CartDao {
    public void create(Cart cart);

    public Cart getCartById(int cartId);

    public void update (Cart cart);

    public void delete (int cartId);
}
