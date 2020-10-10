package com.vn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.vn.demo.model.Account;

@SpringBootApplication
public class Application {
    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		BCryptPasswordEncoder p = new BCryptPasswordEncoder();
		String pass = "123";
		String enc= p.encode(pass);
		System.out.println(pass + enc);
		boolean is = p.matches(pass, enc);
		System.out.println(is);
		
		
		Account a = new Account();
		a.getPassword();
	    a.getUsername();
	    
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/login-javaconfig").allowedOrigins("http://localhost:4200");
			}
		};
	}
	

}
