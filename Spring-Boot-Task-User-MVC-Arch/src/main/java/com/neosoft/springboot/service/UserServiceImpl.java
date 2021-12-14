package com.neosoft.springboot.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.springboot.entity.User;
import com.neosoft.springboot.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;	
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long uid) {
		return userRepository.findById(uid).get();
	}

	@Override
	public User updateUser(User user) {		
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Long uid) {
		userRepository.deleteById(uid);	
	}
	
	@Override
	public List<User> getUserByUname(String uname) {
		return userRepository.findByUname(uname);
	}

	

	//SortByUname
	@Override
	public List<User> sortByUname(){
		
		Comparator<User> byNameComparator = Comparator.comparing(User::getUname);
		return userRepository.findAll().stream().sorted(byNameComparator).collect(Collectors.toList());
	}
	
	//SortByUpass
	@Override
	public List<User> sortByUpass(){
		
		Comparator<User> byUpassComparator = Comparator.comparing(User::getUpass);
		return userRepository.findAll().stream().sorted(byUpassComparator).collect(Collectors.toList());
	}
	
	
	//Extra!!
	@Override
	public List<User> sortByUid(){
		Comparator<User> byIdComparator = Comparator.comparing(User::getUid);
		return userRepository.findAll().stream().sorted(byIdComparator).collect(Collectors.toList());
	}
}
