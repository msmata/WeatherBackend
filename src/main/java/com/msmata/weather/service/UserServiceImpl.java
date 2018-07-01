package com.msmata.weather.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msmata.weather.dao.UserRepository;
import com.msmata.weather.model.Location;
import com.msmata.weather.model.User;
import com.msmata.weather.util.ModelException;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LocationService locationService;
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	public User findById(Integer id) {
		return userRepository.findOne(id);
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}

	public void deleteUserById(Integer id) {
		userRepository.delete(id);
	}

	public boolean isUserExist(User user) {
		return findByUsername(user.getUsername())!=null;
	}
	
	public void deleteAllUsers(){
		userRepository.deleteAll();
	}

}
