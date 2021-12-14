package com.neosoft.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.neosoft.springboot.entity.User;
import com.neosoft.springboot.service.UserService;
import com.neosoft.springboot.service.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		
		model.addAttribute("users",userServiceImpl.getAllUsers());
		
		return "users";
	}
	
	@GetMapping("/users/new")
	public String createUserForm(Model model) {
		
		User User = new User();
		model.addAttribute("user", User);
		
		return "create_user";
	}
	
	@PostMapping("/users")
	public String saveUser(@ModelAttribute("user") User User) {
		
		userServiceImpl.saveUser(User);
		
		return "redirect:/users";
	}
	
	@GetMapping("/users/edit/{uid}")
	public String editUserForm(@PathVariable Long uid, Model model) {
		
		model.addAttribute("user",userServiceImpl.getUserById(uid));
		
		return "edit_user";
	}
	
	@PostMapping("/users/{uid}")
	public String updateUser(@PathVariable Long uid, 
			@ModelAttribute("user") User user,	Model model) {
		
		User existingUser = userServiceImpl.getUserById(uid);
		existingUser.setUid(uid);
		existingUser.setUname(user.getUname());
		existingUser.setUpass(user.getUpass());
		
		userServiceImpl.updateUser(existingUser);
		
		return "redirect:/users";
	}
	
	@GetMapping("/users/{uid}")
	public String deleteUser(@PathVariable Long uid) {
		
		userServiceImpl.deleteUserById(uid);
		
		return "redirect:/users";
	}	
	
	@GetMapping("/users/sortByUname")
	public String getUsersSortedByUname(Model model){	
		model.addAttribute("users",userServiceImpl.sortByUname());
		
		return "sortingbyname";
	}
	
	@GetMapping("/users/sortByUpass")
	public String getUsersSortedByUpass(Model model){	
		model.addAttribute("users",userServiceImpl.sortByUpass());
		
		return "sortByUpass";
	}
	
	  //3rd Mapping---------------------------------------------
	@GetMapping("/users/edits/{uname}")
	public String viewByUname(@PathVariable String uname, Model model) {
		
		model.addAttribute("users",userServiceImpl.getUserByUname(uname));
		
		return "viewByUname";
	}
}
