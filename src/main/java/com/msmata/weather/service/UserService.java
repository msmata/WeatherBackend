package com.msmata.weather.service;


import java.util.List;

import com.msmata.weather.model.User;

public interface UserService {
	
	User findByUsername(String username);
	
	User findById(Integer id);
	
	void saveUser(User user);
	
	void deleteUserById(Integer id);

	List<User> findAllUsers();
	
	void deleteAllUsers();
	
	boolean isUserExist(User user);
	
}
