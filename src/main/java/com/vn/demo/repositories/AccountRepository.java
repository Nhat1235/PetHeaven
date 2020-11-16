package com.vn.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vn.demo.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	public Account findAccountByUsername(String username);

	public Account findByRole(String role);
	
	@Query(value = "SELECT COUNT(Username) AS NumberOfProducts FROM Account", nativeQuery = true)
	public Account getCustomerInfoById(String code);
	

}
