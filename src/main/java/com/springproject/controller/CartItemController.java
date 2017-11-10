package com.springproject.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.springproject.dao.*;
import com.springproject.entity.*;



@Controller
@RequestMapping("/customer")
public class CartItemController {
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CartItemDao cartItemDao;
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/cart")
	public String getListOfItems (Principal principal,  Model theModel) {
		//get current username
		String currentUser = principal.getName();	
		
		//get customerDao with username
		Customer theCustomer = customerDao.getCustomerByname(currentUser);
		
		//response current user cart obj	
		theModel.addAttribute("cart", theCustomer.getCart());

		return "cart";
	}
	
	@RequestMapping("/cart/{productId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addTocart(@PathVariable int productId, Principal principal){
		Product theProduct = productDao.getProduct(productId);

		//get current username
		String currentUser = principal.getName();	
		//get customerDao with username
		Customer theCustomer = customerDao.getCustomerByname(currentUser); 
		//get customer cart
		Cart theCart = theCustomer.getCart();
		//get cartitem form db
		CartItem theCartItem = cartItemDao.getCartItemByProductId(productId,theCart.getCartId());

		//get product price
		double productPrice = productDao.getProduct(productId).getProductPrice();
		
		if(theCartItem != null){
			//get current quantity and increase by one
			int quantity = theCartItem.getQuantity() + 1;
			
			//update cart db
			theCart.setGrandTotal(theCart.getGrandTotal() + productPrice);
			cartDao.update(theCart);
			
			//update cartItem
			theCartItem.setQuantity(quantity);
			double totalPrice = theCartItem.getTotalPrice();
			totalPrice += productPrice;
			theCartItem.setTotalPrice(totalPrice);
			System.out.println("totalPrice : " + totalPrice);
			//update cartitem db
			cartItemDao.updateCartItem(theCartItem);
		

		} else {
			
			//create cartitem obj
			theCartItem = new CartItem();
			theCartItem.setProduct(theProduct);
			theCartItem.setCart(theCart);
			theCartItem.setQuantity(1);
			theCartItem.setTotalPrice(theProduct.getProductPrice());
		
			//save cartitem to db
			cartItemDao.addCartItem(theCartItem);
			
			//update total price
			theCart.setGrandTotal(theCart.getGrandTotal() + productPrice);
			
			//update cart Dao
			cartDao.update(theCart);
		}
		
		//return "redirect:/product/detailInfo/"+productId;
	}
	
	@RequestMapping("/cart/remove")
	public String removeItem(Principal principal){
		//get current username
		String currentUser = principal.getName();	
		//get customerDao with username
		Customer theCustomer = customerDao.getCustomerByname(currentUser); 
		//get customer cart
		Cart theCart = theCustomer.getCart();
		//total price 0
		theCart.setGrandTotal(0);
		//update cart
		cartDao.update(theCart);
		//delete cartItem in the database
		cartItemDao.removeAllCartItems(theCart);
		
		
		
		return "redirect:/customer/cart";
	}
	
	
	
}
