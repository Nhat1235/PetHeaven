package com.vn.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vn.demo.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	public Account findByUsername(String username);

	public Account findByRole(String role);
	
	@Query(value = "Select * from Account where id=:code", nativeQuery = true)
	public Account getAccountInfoById(String code);
	
	

}
