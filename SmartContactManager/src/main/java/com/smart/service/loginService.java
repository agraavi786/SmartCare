package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.UserRepository;
import com.smart.entities.User;

@Service
public class loginService {
	@Autowired
	private UserRepository us;
	
	public boolean authenticate(String email,String password) {
		
		User user = us.getUserByUserName(email);
		if(user==null) {
			return false;
		}
		return user.getPassword().equals(password);
		
	}

}
