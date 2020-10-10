package com.vn.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vn.demo.model.Account;
import com.vn.demo.repositories.AccountRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private AccountRepository call;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Account user = call.findByUsername(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		String roles = user.getRole();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + roles));
		System.out.println(roles);

		UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), grantedAuthorities);

		return userDetails;
	}

}
