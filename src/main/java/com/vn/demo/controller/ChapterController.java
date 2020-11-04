//package com.vn.demo.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.vn.demo.model.Chapter;
//import com.vn.demo.repositories.ChaptersRepository;
//
//@Controller
//public class ChapterController {
//
//	@Autowired
//	ChaptersRepository call;
//	
//	@RequestMapping(value="contact/{code}")
//	public String contactopen(Model model, @PathVariable("code") String code) {
//		List<Chapter> chap = call.findDetail(code);
//		model.addAttribute("chap", chap);
//		List<Chapter> chap1 = call.findAll();
//		model.addAttribute("chap1", chap1);
//		return "contact";
//	}
//}
