package com.springproject.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springproject.dao.ProductDao;
import com.springproject.entity.Product;


@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/list")
	public String getProducts(Model theModel){
		// get products from the dao
		List<Product> theProducts = productDao.getProducts();
		
		// add the products to the model 
		theModel.addAttribute("products", theProducts);
	
		return "productList";
		
	}
	
	
	@RequestMapping("/detailInfo")
	public String getProductDetailInfo(@RequestParam("productId") int theId, Model theModel){
		// get products from the dao
		Product theProduct = productDao.getProduct(theId);
		
		// add the products to the model 
		theModel.addAttribute("product", theProduct);

		return "viewProduct";
		
	}
	
    @RequestMapping("/detailInfo/{productId}")
    public String getProductDetailInfoByPathVariable(@PathVariable int productId, Model theModel){
		// get products from the dao
		Product theProduct = productDao.getProduct(productId);
		
		// add the products to the model 
		theModel.addAttribute("product", theProduct);

		return "viewProduct";
    }
	

}