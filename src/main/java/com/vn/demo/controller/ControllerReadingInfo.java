package com.vn.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.demo.model.Category;
import com.vn.demo.model.Chapter;
import com.vn.demo.model.ReadingInfo;
import com.vn.demo.repositories.CategoryRepository;
import com.vn.demo.repositories.ChaptersRepository;
import com.vn.demo.repositories.ReadingRepository;

@Controller
public class ControllerReadingInfo {

	@Autowired
	private ReadingRepository call;

	@Autowired
	private ChaptersRepository callChap;

	@Autowired
	private CategoryRepository callCa;

	@RequestMapping("/")
	public String homePage(Model model) {
		List<ReadingInfo> list = call.findAll();
		model.addAttribute("list", list);
		List<Category> ca = callCa.fetchAllType();
		model.addAttribute("ca", ca);
		return "index";
	}

	@RequestMapping("/New")
	public String New(Model model) {
		List<ReadingInfo> list = call.OrderByDateDesc();
		model.addAttribute("list", list);
		List<Category> ca = callCa.fetchAllType();
		model.addAttribute("ca", ca);
		return "index1";
	}
	@GetMapping(value="/Category/{code}")
    public String cate(Model model, @ModelAttribute("list")@PathVariable("code")String code) {
		List<ReadingInfo> list = call.findBycategory(code);
		model.addAttribute("list", list);
		System.out.println("code:" + code);
		List<Category> ca = callCa.fetchAllType();
		model.addAttribute("ca", ca);
		return "Category";
	}
	@GetMapping(value = "single/{code}")
	public String InfoPage(Model model, @ModelAttribute("list") @PathVariable("code") String code) {
		List<ReadingInfo> list = call.findByCode(code);
		model.addAttribute("list", list);
		List<Chapter> chap = callChap.findChapterName(code);
		model.addAttribute("chap", chap);
		System.out.println("code:" + code);
		return "single";
	}
}
