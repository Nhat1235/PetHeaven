package com.vn.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.demo.model.Category;
import com.vn.demo.model.Product;
import com.vn.demo.repositories.ProductRepository;
import com.vn.demo.service.CategoryService;
import com.vn.demo.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	
	
	@Autowired
	ProductService productService; 
	
	@Autowired
	ProductRepository rep;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("list")
	public String shop(Model model) {
		List<Product> list = rep.findAll();
		model.addAttribute("ProductList", list);
		/* List<Category> catelist = CategoryService.getFoodName(); */
		model.addAttribute("animalfood", categoryService.getFoodName());
		model.addAttribute("accessories", categoryService.getAccessoriesName());
		return "backup/QLMH.html";
	}

	
	
	//@GetMapping
//	@GetMapping("/list")
//	public String getList(Model model) {
////		System.out.println(groupManageService.getList());
//		model.addAttribute("key", productService.getProductList());
//
//		return "backup/QLMH.html";
//	}
//	
//	
	@RequestMapping("/add")
	  public String add(Model model ) {
		model.addAttribute("categoryes", categoryService.getCategoryList());
		model.addAttribute("product", new Product());
	    return "backup/aa";
	  }
	
//	 @RequestMapping("/product-save")
//	  public String insertProduct(Model model) {
//	    model.addAttribute("product", new Product());
//	    return "redirect:list";
//	 }
	  @PostMapping("/saveProduct")
	  public String doSaveProduct(@ModelAttribute("Product") Product product, Model model) throws ParseException {
		System.out.println("hihiihihiiaisgdiuas "+product);
				
		product.setCreateDate(new Date());
		
	    productService.save(product);
	    
	    return "redirect:list";
	  }
	  @GetMapping("{id}")
	  public String deleteProduct(@PathVariable("id") int id) {
		  
		  productService.deleteProduct(id);
		  
		  return "redirect:list";
	  }
	  
	
	
 }
