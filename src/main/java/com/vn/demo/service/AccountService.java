package com.vn.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vn.demo.model.Account;
import com.vn.demo.repositories.AccountRepository;

@Service
public class AccountService {
    
	
	@Autowired
	AccountRepository accountrepository;
	
	public List<Account> getAccountList() {
		return accountrepository.findAll();
	}

	public Account getAccountById(Integer id) {
		return accountrepository.findById(id).get();
	}

	public void saveOrUpdateAccount(Account account) {
		accountrepository.save(account);
	}
	
	public void deleteAccount(Integer id) {
		accountrepository.deleteById(id);
	}

	public void save(Account account) {
		accountrepository.save(account);
		
	}

}
