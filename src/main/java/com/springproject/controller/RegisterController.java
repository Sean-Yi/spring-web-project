package com.springproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springproject.dao.*;
import com.springproject.entity.*;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private CustomerDao CustomerDao;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		//if string only has white space, trim it to null
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
    @RequestMapping("")
    public String registerCustomer(Model model) {

        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);

        model.addAttribute("customer", customer);

        return "registerCustomer";

    }
    
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer theCustomer, 
    								   BindingResult theBindingResult)
    {
		if(theBindingResult.hasErrors()){
			
			System.out.println("error");
			return "registerCustomer";
			
			
		} else {
			
			CustomerDao.saveCustomer(theCustomer);

    	 return "registerSuccess";
		}
    }	
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
