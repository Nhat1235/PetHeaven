package com.vn.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	/*
	 * @Bean public AuthenticationProvider authprovider() {
	 * DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	 * provider.setUserDetailsService(userDetailsService);
	 * provider.setPasswordEncoder(new BCryptPasswordEncoder());
	 * provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
	 * 
	 * return provider; }
	 */

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

		http.authorizeRequests().antMatchers("/admin/assets/datatable/datatables.css").permitAll().and().csrf()
				.disable();

		http.authorizeRequests()
				 .antMatchers("/admin/").hasRole("ADMIN") 
				// cho phép hiệu ứng, không chặn các file css,js,bootstrap
				.antMatchers("/", "/Dangky","/shop","/shop-detail/**","/cart").permitAll()
				
//				  .antMatchers("/resources/**", "/templates/**", "/static/**", "/css/**","/js/**", "/images/**", "/webfonts/**").permitAll()
				 
				.anyRequest().fullyAuthenticated().and().formLogin().loginPage("/login").permitAll()
				.defaultSuccessUrl("/", true).and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login").permitAll().and().csrf().disable();
		
	}


	  @Override
	    public void configure(WebSecurity web) throws Exception {
	       web.ignoring().antMatchers("/css/**","/js/**","/images/**","/webfonts/**","/icon/**");
	    }
	
}