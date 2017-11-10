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
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userId")
    private int userId;
	
	@Column(name="username")
    private String username;
    
	@Column(name="password")
    private String password;
    
	@Column(name="enabled")
    private boolean enabled;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private Customer customer;
    
    
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomerId(Customer customer) {
		this.customer = customer;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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

    
    
}
