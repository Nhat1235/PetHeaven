package com.vn.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.demo.model.Account;
import com.vn.demo.repositories.AccountRepository;

@Controller
public class AccountController {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	PasswordEncoder passwordEncoder;
	
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
	public String checkpersoninfo(@Valid @ModelAttribute("account")Account account,@RequestParam("password") String password ,BindingResult error) {
		if(error.hasErrors()) {
			return"Dangky";
		}
		try {
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encryptPassword = encoder.encode(password.trim());
			account.setPassword(encryptPassword);
			account.setRole("ROLE_USER");
			
			accountRepository.save(account);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "login1.html";
	}
}
