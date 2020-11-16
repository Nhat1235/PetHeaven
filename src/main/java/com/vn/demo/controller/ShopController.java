package com.vn.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.demo.model.Product;
import com.vn.demo.service.ProductService;

@Controller
@RequestMapping("/shop")
public class ShopController {
 
	@Autowired
	ProductService service;
	
	@RequestMapping("")
	public String shop(Model model) {
		List<Product> list = service.getProductList();
		model.addAttribute("ProductList", list);
		return "shop.html";
	}
	
	
}
