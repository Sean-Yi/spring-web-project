package com.springproject.dao;

import java.util.List;

import com.springproject.entity.Product;

public interface ProductDao {
	
	public List<Product> getProducts();

	public void saveProduct(Product theProduct);

	public Product getProduct(int theProductId);

	public void deleteProduct(int theProductId);
}
