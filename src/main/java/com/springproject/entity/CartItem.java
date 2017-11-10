package com.springproject.entity;

import javax.persistence.*;


@Entity
@Table(name="CartItem")
public class CartItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cartItemId")
    private int cartItemId;
	
    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			   CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "cart")
    private Cart cart;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			   CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "product")
    private Product product;
    
    @Column(name="quantity")
    private int quantity;
    
	@Column(name="totalPrice")
    private double totalPrice;
    
    
	
    public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	
}			
