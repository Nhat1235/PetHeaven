package com.vn.demo.controller;



import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vn.demo.model.Account;
import com.vn.demo.repositories.AccountRepository;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class ControllerAccount {

	@Autowired
	AccountRepository call;
	@Autowired
	ServletContext servletContext;
	
	@GetMapping("/login")
	public String login(ModelMap model) {
		return "login1";
	}

	@RequestMapping(value="/Dangky",method = RequestMethod.GET)
	public String register(ModelMap model) {
		model.addAttribute("account", new Account());
		return "Dangky";
	}
	
	@RequestMapping(value="/Dangky",method = RequestMethod.POST)
	public String checkpersoninfo(@Valid @ModelAttribute("account")Account account,BindingResult error) {
		if(error.hasErrors()) {
			return"Dangky";
		}
		try {
		  call.save(account);
		  System.out.println("đây là đăng ký");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "login";
	}
}
