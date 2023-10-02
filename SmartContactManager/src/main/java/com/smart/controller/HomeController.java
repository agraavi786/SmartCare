package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.dao.UserRepository;
import com.smart.entities.User;
import com.smart.helper.Message;
import com.smart.service.loginService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	private loginService ls;
	@Autowired
	private UserRepository up;
	
	
	
	
	
	
	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("title","Smart contact manager");
		return "home";
	}
	
	@GetMapping("/about")
	public String about(Model m) {
		m.addAttribute("title","ABout-Smart contact manager");
		return "about";
	}
	@GetMapping("/signup")
	public String signUp(Model m) {
		m.addAttribute("title","SignUp-Smart contact manager");
		m.addAttribute("user" , new User());
		return "signup";
	}
	
	@PostMapping("/do_register")
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult br,
			
			@RequestParam(value="agreement",defaultValue = "false") 
			boolean agreement,Model model,HttpSession session) {
		
		try {
			
			if(!agreement) {
				System.out.println("You have agree the team and condtions");
				
			 throw new Exception("You have not agree the team and condtions");
			}
			if(br.hasErrors()) {
				System.out.println("ERROR IS : " + br.toString());
				model.addAttribute("user" , user);
				
				return "signup";
			}
			
			
			user.setRole("Officer");
			user.setEnable(true);
			user.setImageUrl("default.jpg");
			System.out.println("Agreement" + agreement);
			System.out.println("USER: " + user);
			
			User result = this.up.save(user);
			
			
			
			model.addAttribute("user",new User());
			
			session.setAttribute("message", new Message("Successfully registred !!", "alert-success"));
			
			return "success";
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			model.addAttribute("user",user);
			session.setAttribute("message", new Message("Something went wrong !!"+ e.getMessage(), "alert-danger"));
		}
		return "signup";
	}
	
	@GetMapping("/login")
	public String userLogin() {
		
		return "login";
	}
	
	
	@PostMapping("/do_login")
	public String getDetails(@ModelAttribute("user") User user) {
		
		String email=user.getEmail();
		String password= user.getPassword();
		
		boolean authe = ls.authenticate(email, password);
		
		if(!authe) {
			return "login";
		}
		
		
		
		
		return "success";
	}
	

}
