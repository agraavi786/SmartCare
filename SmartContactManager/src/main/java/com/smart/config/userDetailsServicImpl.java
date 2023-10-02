//package com.smart.config;
//
//import java.nio.file.attribute.UserPrincipalNotFoundException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import com.smart.dao.UserRepository;
//import com.smart.entities.User;
//
//public class userDetailsServicImpl implements UserDetailsService{
//	@Autowired
//	private UserRepository us;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		
//		User user = us.getUserByUserName(username);
//		
//		if(user==null) {
//			
//			throw new UsernameNotFoundException("Could nor found the user !!");
//		}
//		
//		customeUserDetails cud= new customeUserDetails(user);
//		
//		return cud;
//	}
//
//}
