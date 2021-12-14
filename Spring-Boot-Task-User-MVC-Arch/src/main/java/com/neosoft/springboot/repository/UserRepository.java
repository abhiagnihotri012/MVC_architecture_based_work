package com.neosoft.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.springboot.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
	List<User> findByUname(String uname);
}
