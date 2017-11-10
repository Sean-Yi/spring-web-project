package com.springproject.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	
    @RequestMapping("/loginFail")
    public String error(Model theModel)
    {	
    	System.out.println("loginfail");
    	theModel.addAttribute("error", "Invalid username and password");
        return "login";
    }

    @RequestMapping("/login")
    public String login()
    {
    	System.out.println("login");
        return "login";
    }
    
   
	@RequestMapping("/logout")
    public String logout(Model theModel, HttpServletRequest request)
    {

        SecurityContextHolder.getContext().setAuthentication(null);
    	theModel.addAttribute("msg", "You hav been logged out successfully");
        return "login";
    }

}
