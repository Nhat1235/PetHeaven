package com.vn.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.demo.model.Category;
import com.vn.demo.repositories.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	CategoryRepository category;

	@RequestMapping("Category")
	public String a(ModelMap model) {
		List<Category> list = category.findAll();
		model.addAttribute("category", list);
		return "Category";
	}
}
