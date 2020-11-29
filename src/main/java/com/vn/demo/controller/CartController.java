package com.vn.demo.controller;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.demo.model.Cart;
import com.vn.demo.model.Product;
import com.vn.demo.repositories.ProductRepository;
import com.vn.demo.service.CartManager;

@Controller
@RequestMapping("cart")
public class CartController {

	@Autowired
	private ProductRepository repo;

	@Autowired
	private CartManager cartManager;
   
	
	@RequestMapping("{id}")
	public String cart(@PathVariable("id") Product product, Model model) {
		model.addAttribute("product", product);
		return "cart.html";
	}
	
	@RequestMapping("/shop1")
	public String shop(Model model) {
		model.addAttribute("products", repo.findAll());
		return"shop1";
	}
	
	@RequestMapping("")
	public String cart1(Model model) {
		return "cart.html";
	}
	
	@RequestMapping("/product1/{id}")
	public String cartproduct(@PathVariable("id") Product product, Model model) {
		model.addAttribute("product", product);
		return "product.html";
	}
	
	@RequestMapping("add")
	public String add(HttpSession session, @RequestParam("id") Product product,
			@RequestParam(value = "quan", required = false, defaultValue = "1") int quantity) {
		Cart cart = cartManager.getCart(session);
		cart.addItem(product, quantity);

		return "cart1.html";
	}

	@PostMapping("remove")
	public String remove(HttpSession session, @RequestParam("id") Product product) {
		Cart cart = cartManager.getCart(session);
		cart.removeItem(product);
		return "cart1.html";
	}

	@PostMapping("update")
	public String update(HttpSession session, @RequestParam("id") Product product, @RequestParam("quan") int quantity) {
		Cart cart = cartManager.getCart(session);
		cart.updateItem(product, quantity);
		return "cart1.html";
	}

}
