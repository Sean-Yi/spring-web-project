package com.springproject.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.springproject.entity.Product;
import com.springproject.dao.*;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Value("${xmlImgPath}")
	private String xmlImgPath;
	
	@Autowired
	private ProductDao productDao;
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		//if string only has white space, trim it to null
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	
	
	@RequestMapping()
	public String adminPage(){
		
		return "admin";
	}

	
	@RequestMapping("/productInventory")
	public String getProducts(Model theModel){
		// get products from the dao
		List<Product> theProducts = productDao.getProducts();
		
		// add the products to the model 
		theModel.addAttribute("products", theProducts);
	
		return "productInventory";
		
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(Model theModel){
		
		// create model attribute to bind form data
		Product theProduct = new Product();
		
		
		//set default value
		theProduct.setProductCategory("instrument");
		theProduct.setProductCondition("new");
		theProduct.setProductStatus("active");
		
		theModel.addAttribute("product", theProduct);
		
		return "addProduct";
		
	}
	
	@RequestMapping(path = "/addProduct" , method = RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute("product") Product theProduct, 
							     BindingResult theBindingResult,
								 HttpServletRequest request)
	{
		
		if(theBindingResult.hasErrors()){
			
			System.out.println("error");
			return "addProduct";
		} else {
			
			//save the product using dao
			productDao.saveProduct(theProduct);
			
			//save image in to the server
			String name = String.valueOf(theProduct.getProductId());
			MultipartFile file = theProduct.getProductImage();
			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
	
					//set path to store file
					String storagePath = xmlImgPath;
	
					// Create the file on server
					File serverFile = new File(storagePath + File.separator + name +".jpg");
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
	
	
					System.out.println("You successfully uploaded file=" + name);
		
				} catch (Exception e) {
					System.out.println("You failed to upload " + name + " => " + e.getMessage());
				}
			} else {
				System.out.println("You failed to upload " + name + " because the file was empty.");

			}
		
			return "redirect:/admin/productInventory";
			
		}
	}
	
	@RequestMapping("/editProduct")
	public String editProduct(@RequestParam("productId") int theId, Model theModel){
		
		// get products from the dao
		Product theProduct = productDao.getProduct(theId);
		
		// add the products to the model 
		theModel.addAttribute("product", theProduct);

		return "editProduct";
		
	}
	
	
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId") int theId){
		
		//delet file in the server
		String name = String.valueOf(theId);
		Path path = Paths.get(xmlImgPath+ File.separator + name +".jpg");
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		//delete product in the database
		productDao.deleteProduct(theId);
		
		return "redirect:/admin/productInventory";
	}
	
}
