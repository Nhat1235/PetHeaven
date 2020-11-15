package com.vn.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopController {
 
	@RequestMapping("")
	public String shop() {
		return "shop.html";
	}
}
