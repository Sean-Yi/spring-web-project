package com.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springproject.dao.CartDao;
import com.springproject.dao.CustomerOrderDao;
import com.springproject.entity.Cart;
import com.springproject.entity.Customer;
import com.springproject.entity.CustomerOrder;


@Controller
public class OrderController {
	
    @Autowired
    private CartDao cartDao;

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId, Model theModel) {
    	CustomerOrder customerOrder = new CustomerOrder();
        Cart cart=cartDao.getCartById(cartId);
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customerOrder.setShippingAddress(customer.getShippingAddress());

      
        theModel.addAttribute("order", customerOrder);

        return "orderConfirmation";
    }
    
    
    @RequestMapping(path = "/order/success/{cartId}")
    public String orderSuccess(@PathVariable("cartId") int cartId, Model theModel) {
    	
    	CustomerOrder customerOrder = new CustomerOrder();
        Cart cart=cartDao.getCartById(cartId);
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customerOrder.setShippingAddress(customer.getShippingAddress());
        
    	customerOrderDao.addCustomerOrder(customerOrder);
    	
    	return "orderSuccess";
    }
    
    
    @RequestMapping("/order/cancel")
    public String orderSuccess (){
    	
    	System.out.println("cancel wotking");

    	return "orderCancel";
    }

}
