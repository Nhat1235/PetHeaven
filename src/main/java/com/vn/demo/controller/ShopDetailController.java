package com.vn.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("shop-detail")
public class ShopDetailController {

	@RequestMapping("")
	public String detailShop() {
		return "shop-detail.html";
	}
}
