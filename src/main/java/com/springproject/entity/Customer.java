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
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name="Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customerId")
	private int customerId;
	
	@NotNull(message ="is required")
	@Size(min=1, max=20, message="Size must be between 0 and 20")
	@Column(name="customerName")
	private String customerName;
	
	@NotNull(message ="is required")
	@Size(min=1, max=20, message="Size must be between 0 and 50")
	@Column(name="customerEmail")
	private String customerEmail;
	
	@NotNull(message ="is required")
	@Size(min=1, max=20, message="Size must be between 0 and 20")
	@Column(name="customerPhone")
	private String customerPhone;
	
	@NotNull(message ="is required")
	@Size(min=1, max=20, message="Size must be between 0 and 20")
	@Column(name="username")
	private String username;
	
	@NotNull(message ="is required")
	@Size(min=1, max=20, message="Size must be between 0 and 20")
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@Valid
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="billingAddressId")
	private BillingAddress billingAddress;
	
	@Valid
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="shippingAddressId")
	private ShippingAddress shippingAddress;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "cartId")
    private Cart cart;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerPhone=" + customerPhone + ", username=" + username + ", password="
				+ password + ", enabled=" + enabled + ", billingAddress=" + billingAddress + ", shippingAddress="
				+ shippingAddress + ", cart=" + cart + "]";
	}
      
    

}
