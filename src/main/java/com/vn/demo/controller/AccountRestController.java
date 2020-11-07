package com.vn.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vn.demo.model.Account;
import com.vn.demo.service.AccountService;

@RestController
public class AccountRestController {

	@Autowired
	AccountService accountrepo;
	
	@GetMapping( path = "/account", produces = "application/json")
	public List<Account> getAll(){
		return accountrepo.getAccountList();
	}
	
	@PostMapping("account/create")
	public ResponseEntity<Void> saveAccount(@RequestBody Account account) {
		accountrepo.save(account);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("account/update")
	public ResponseEntity<Void> saveOrUpdateAccount(@RequestBody Account account) {
		accountrepo.saveOrUpdateAccount(account);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/account/delete/{id}")
	public ResponseEntity<Void> deleteAccount(@PathVariable Integer id) {
		accountrepo.deleteAccount(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
