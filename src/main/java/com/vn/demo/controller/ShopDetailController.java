package com.vn.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vn.demo.model.Product;
import com.vn.demo.repositories.ProductRepository;
import com.vn.demo.repositories.ShopDetailRepository;

@Controller
 @RequestMapping("shop-detail") 
public class ShopDetailController {

	@Autowired
	ShopDetailRepository repository;
	
	@Autowired
	ProductRepository rep;
	
	@RequestMapping(value="{idProduct}", method = RequestMethod.GET)
	public String detailShop(Model model,@PathVariable("idProduct")Integer id) {
		List<Product> list = rep.findProductById(id);
		model.addAttribute("ProductList", list);
		List<Product> list2 = rep.findAll();
		model.addAttribute("List", list2);
		return "shop-detail.html";
	}
}
