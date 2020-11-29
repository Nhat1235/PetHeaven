package com.vn.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vn.demo.model.Category;
import com.vn.demo.model.Product;
import com.vn.demo.repositories.ProductRepository;
import com.vn.demo.service.CategoryService;
import com.vn.demo.service.ProductService;

@Controller
@RequestMapping("shop") 
public class ShopController {

	@Autowired
	ProductService service;

	@Autowired
	ProductRepository rep;

	@Autowired
	CategoryService CategoryService;

	@RequestMapping("")
	public String shop(Model model) {
//		PageWrapper<Product> list = new PageWrapper<Product>(rep.findAll(PageRequest.of(0, 13)),"");
		Page<Product> list =  rep.findAll(PageRequest.of(0, 15));
		model.addAttribute("ProductList", list);
		model.addAttribute("totalProduct1page", list.getSize());
//		model.addAttribute("totalProduct", list.getTotalElements());
		model.addAttribute("page", list.getTotalPages());
		/* List<Category> catelist = CategoryService.getFoodName(); */
		model.addAttribute("animalfood", CategoryService.getFoodName());
		model.addAttribute("accessories", CategoryService.getAccessoriesName());
		return "shop.html";
	}

	@RequestMapping(value = "/page/{Pnum}", method = RequestMethod.GET)
	public String page(Model model, @PathVariable Integer pnum) {
		Page<Product> list = rep.findAll(PageRequest.of(pnum, 9));
		model.addAttribute("ProductList", list);
		return "shop.html";
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String findByCategory(@PathVariable("id") Category id, Model model) {

//		  Page<Product> list = rep.getProductbyCategoryId(id,PageRequest.of(0, 13));
		 
		List<Product> list = rep.findByCategoryId(id);
		
//		PageWrapper<Product> list = new PageWrapper<Product>(rep.getProductbyCategoryId(id,PageRequest.of(0, 13)), "{id}");
		
//		  model.addAttribute("totalProduct1page", list.getSize());
		  
//		  model.addAttribute("totalProduct", list.getTotalElements());
		  
//		  model.addAttribute("page", list.getTotalPages());
		  
		model.addAttribute("ProductList", list);
		model.addAttribute("animalfood", CategoryService.getFoodName());
		model.addAttribute("accessories", CategoryService.getAccessoriesName());

		return "shop.html";
	}

}
