package com.vn.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vn.demo.model.Cart;
import com.vn.demo.model.CartManager;
import com.vn.demo.model.Product;
import com.vn.demo.repositories.ProductRepository;
import com.vn.demo.service.ProductService;

@Controller
@RequestMapping("cart")
public class CartController {

	@Autowired
	private ProductRepository repo;
    @Autowired
    private ProductService sv;
    
    private ProductService productService;

	public CartController(ProductService productService) {
		this.productService = productService;
	}
	
    @Autowired 
    CartManager cartManager;
     
	
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
	
//	@RequestMapping("/add")
//	public String add(HttpSession session, @RequestParam("id") Integer id, @RequestParam(value = "qty", required = false, defaultValue = "1") int qty) {
//		Product product= sv.get(id);
//		Cart cart = cartManager.getCart(session);
//		cart.addItem(product, qty);
//		return "cart";
//	}
//	
//	@RequestMapping("/remove")// xoa san pham trong gio hang
//	public String remove(HttpSession session, @RequestParam("id") Integer id) {
//		Product product= sv.get(id);
//		Cart cart = cartManager.getCart(session);
//		cart.removeItem(product);
//		return "cart";
//	}
//	
//	@RequestMapping("/update")
//	public String update(HttpSession session, @RequestParam("id") Integer id,@RequestParam("qty") int qty) {
//		Product product= sv.get(id);
//		Cart cart = cartManager.getCart(session);
//		cart.updateItem(product, qty);
//		
//		return "cart";
//	}
	
	
	
	@RequestMapping("/home")
	public String getAll(Model model) {

		List<Product> products = productService.listAll();
		model.addAttribute("products", products);

		return "home";

	}
	
	@RequestMapping("/addToCart/{id}")
	public String addToCart(@PathVariable("id") int id, Model model, HttpSession session) {

		Product p = productService.getProductById(id);

		if (session.getAttribute("prodsess") == null) {

			Map<String, Integer> cart = new HashMap<>();
			cart.put(p.getName(), (int) p.getPrice());
			session.setAttribute("prodsess", cart);
			model.addAttribute("cart", cart);
			Integer sum = 0;
			for (Integer val : cart.values()) {
				sum += val;
			}
			model.addAttribute("sum", sum);
			
		} else {

			Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("prodsess");
			cart.put(p.getName(), (int) p.getPrice());
			session.setAttribute("prodsess", cart);
			model.addAttribute("cart", cart);
			Integer sum = 0;
			for (Integer val : cart.values()) {
				sum += val;
			}
			model.addAttribute("sum", sum);

		}

		return "cart";

	}

	@RequestMapping("/cart")
	public String cart(HttpSession session,@RequestParam("quantity") int quantity, Model model) {

		Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("prodsess");
		model.addAttribute("cart", cart);
		Integer sum = 0;
		for (Integer val : cart.values()) {
			sum += val;
		}
		model.addAttribute("sum", sum);
		return "cart";
	}

	@RequestMapping("/delete/{key}")
	public String deleteFromCart(@PathVariable("key") String key, HttpSession session, Model model) {

		Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("prodsess");
		cart.remove(key);
		Integer sum = 0;
		for (Integer val : cart.values()) {
			sum += val;
		}
		session.setAttribute("prodsess", cart);
		model.addAttribute("cart", cart);
		model.addAttribute("sum", sum);
		
		return "cart";
	}


}
