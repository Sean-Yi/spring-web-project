package com.springproject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CustomerOrder")
public class CustomerOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customerOrderId")
    private int customerOrderId;

    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			   CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "cartId")
    private Cart cart;
    
    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			   CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "customerId")
    private Customer customer;
	 
    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			   CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

    @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			   CascadeType.DETACH, CascadeType.REFRESH})
    
    @JoinColumn(name="shippingAddressId")
    private ShippingAddress shippingAddress;

    
	public int getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(int customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}
