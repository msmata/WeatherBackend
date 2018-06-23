package com.msmata.weather.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msmata.weather.dao.UserRepository;
import com.msmata.weather.model.User;



@Service("usuarioService")
public class UsuarioServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	public User findById(Integer id) {
		return userRepository.findOne(id);
	}
	
	public User findByUsername(String name) {
		return userRepository.findByUsername(name);
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
