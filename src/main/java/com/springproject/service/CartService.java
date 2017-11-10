package com.springproject.service;

import com.springproject.entity.*;

public interface CartService {

    Cart getCartById (int cartId);

    void update(Cart cart);
}
