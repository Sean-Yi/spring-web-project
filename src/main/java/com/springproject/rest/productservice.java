package com.springproject.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.dao.ProductDao;
import com.springproject.entity.Product;

@RestController // automatically @ResposeBody is assumed on every method
@RequestMapping("/service/product")
public class productservice {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value = "/searchall", method = RequestMethod.GET)
	public List<Product> getAllProduct() {
		
		List<Product> products = productDao.getProducts();
		return products;

	}
	
	@RequestMapping(value = "/search/{theProductId}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable int theProductId) {
		
		Product theProduct = new Product();
		theProduct = productDao.getProduct(theProductId);
		return theProduct;

	}
	
	@RequestMapping(value = "/update/{theProductId}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateProduct(@PathVariable("theProductId") int theProductId, @RequestBody Product theProduct ) {
		if(productDao.getProduct(theProductId) == null){
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			productDao.saveProduct(theProduct);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Void> addProduct(@RequestBody Product theProduct ) {
		
		//check theProduct.getProductId() is empty because id is Automatically provided by AI 
		if(theProduct.getProductId() == 0){
			productDao.saveProduct(theProduct);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}		
	}
	
	@RequestMapping(value = "/delete/{theProductId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProduct(@PathVariable int theProductId) {
		
		if(productDao.getProduct(theProductId) == null){
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			productDao.deleteProduct(theProductId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}	
	}
}
