package com.vn.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.demo.model.Account;
import com.vn.demo.model.Category;
import com.vn.demo.model.ReadingInfo;
import com.vn.demo.repositories.AccountRepository;
import com.vn.demo.repositories.CategoryRepository;
import com.vn.demo.repositories.ReadingRepository;

@Controller
@RequestMapping("admin")
public class ControllerAdmin {
	@Autowired
	ReadingRepository call;
	@Autowired
	AccountRepository Acall;
	@Autowired
	CategoryRepository callCa;

	@RequestMapping("/index")
	public String adminPage(Model model) {
		List<Account> list = Acall.findAll();
		model.addAttribute("list", list);
		return "adminPage";
	}

	@PostMapping(value = "/updateAccount/{code}")
	public String update1(Model model, @PathVariable("code") Integer code, @Valid Account account,
			BindingResult error) {
		if (error.hasErrors()) {
			account.setId(code);
			return "updateAccount";
		}
		try {
			Acall.save(account);
			System.out.println("đây là đăng ký");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "adminPage";
	}

	@GetMapping(value = "/updateAccount/{code}")
	public String update(Model model, @PathVariable("code") String code) {
		model.addAttribute("account", new Account());
		return "updateAccount";
	}

	@RequestMapping(value = "adminPage/{code}")
	public String delete(Model model, @PathVariable("code") Integer code) {
		try {
			Acall.deleteById(code);
			System.out.println("đây là xóa tài khoản");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	@RequestMapping("/read")
	public String read(Model model) {
		List<ReadingInfo> list = call.findAll();
		model.addAttribute("list", list);
		List<Category> ca = callCa.fetchAllType();
		model.addAttribute("ca", ca);
		return "read";
	}
	
	@RequestMapping(value = "read/{code}")
	public String deleteT(Model model, @PathVariable("code") Integer code) {
		try {
			call.deleteById(code);
			System.out.println("đây là xóa truyện");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

}
