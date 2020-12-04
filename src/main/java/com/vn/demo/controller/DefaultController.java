package com.vn.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.demo.model.Product;
import com.vn.demo.repositories.ProductRepository;

@Controller
public class DefaultController {
	
	@Autowired
	ProductRepository rep;

	@RequestMapping("")
	public String shop(Model model) {
		List<Product> list = rep.findAll();
		model.addAttribute("ProductList", list);
		return "index.html";
	}

}
