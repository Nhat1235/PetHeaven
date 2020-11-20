package com.vn.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
 @RequestMapping("shop-detail") 
public class ShopDetailController {

	@RequestMapping(value="{idProduct}", method = RequestMethod.GET)
	public String detailShop(Model model) {
		
		return "shop-detail.html";
	}
}
