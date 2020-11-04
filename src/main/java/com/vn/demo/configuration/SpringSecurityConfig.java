package com.vn.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    
	@Autowired
	private UserDetailsService userDetailsService;

//	@Bean
//	public AuthenticationProvider authprovider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
////		provider.setPasswordEncoder(new BCryptPasswordEncoder());
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//		
//		return provider;
//	}
	
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
    }
	 
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    	
	        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	        
	    }
	    

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
		// cho phép hiệu ứng, không chặn các file css,js,bootstrap
		.antMatchers("/css/**", "/js/**", "/images/**").permitAll()
		.antMatchers(HttpMethod.GET, "/css/**", "/js/**","/fonts/**","/**/favicon.ico", "/about").permitAll()
		.antMatchers("/admin/").hasRole("ADMIN")
		.antMatchers("/","/Dangky","/category","/New")
		.permitAll().anyRequest().authenticated()
		
				.and().
				formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/")
				.permitAll().and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
				.permitAll();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	            .ignoring()
	            .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/Pages/**");
	}
}
