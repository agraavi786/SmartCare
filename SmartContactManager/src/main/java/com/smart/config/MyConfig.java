//package com.smart.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.SecurityBuilder;
//import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class MyConfig  extends SecurityConfigurerAdapter {
//	@Bean
//	public UserDetailsService getUserDetailService() {
//		
//		
//		return new userDetailsServicImpl();
//		
//	
//	}
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//		
//	}
//	
//	@Bean
//	
//	public DaoAuthenticationProvider authenticationProvider() {
//		
//		DaoAuthenticationProvider dap= new DaoAuthenticationProvider();
//		
//		
//		dap.setUserDetailsService(this.getUserDetailService());
//		dap.setPasswordEncoder(passwordEncoder());
//		return dap;
//	}
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth.authenticationProvider(authenticationProvider());
//		
//		
//	};
//	
//	
////	public void configure(HttpSecurity http) throws Exception{
////		
////		http.authorizeRequests()http.match
////	}
//	
//	
//	
//	
//	
//	
//	
//
//}
