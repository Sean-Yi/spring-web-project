package com.springproject.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ShippingAddress")
public class ShippingAddress {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="shippingAddressId")
    private int shippingAddressId;
	
	@NotNull(message ="is required")
	@Size(min=1, max=20, message="Size must be between 0 and 20")
	@Column(name="streetName")
    private String streetName;
	
	@NotNull(message ="is required")
	@Size(min=1, max=20, message="Size must be between 0 and 20")
	@Column(name="apartmentNumber")
    private String apartmentNumber;
	
	@NotNull(message ="is required")
	@Size(min=1, max=20, message="Size must be between 0 and 20")
	@Column(name="city")
    private String city;
	
	@NotNull(message ="is required")
	@Size(min=1, max=20, message="Size must be between 0 and 20")
	@Column(name="state")
    private String state;
	
	@NotNull(message ="is required")
	@Size(min=1, max=20, message="Size must be between 0 and 20")
	@Column(name="country")
    private String country;
	
	@NotNull(message ="is required")
	@Size(min=1, max=20, message="Size must be between 0 and 20")
	@Column(name="zipCode")
    private String zipCode;
	

    @OneToOne(mappedBy="shippingAddress")
    private Customer customer;

	public int getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
