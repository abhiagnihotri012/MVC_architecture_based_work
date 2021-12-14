package com.neosoft.springboot.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.neosoft.springboot.entity.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	User saveUser(User user);
	
	User getUserById(Long uid);
	
	User updateUser(User user);
	
	void deleteUserById(Long uid);
	
	List<User> getUserByUname(String uname);
	
	List<User> sortByUname();
	
	List<User> sortByUpass();
	
	List<User> sortByUid();
	
//	void updatingUser(User user,Long id);
}
