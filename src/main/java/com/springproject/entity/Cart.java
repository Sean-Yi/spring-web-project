package com.springproject.entity;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cartId")
	private int cartId;

	@OneToMany(mappedBy="cart",cascade= {CascadeType.ALL}, fetch=FetchType.EAGER)
    private List<CartItem> cartItems;

	@OneToOne(mappedBy="cart")
	private Customer customer;
	
	@Column(name="grandtotal")
	private double grandTotal;
	
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	

}
