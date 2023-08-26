package com.steven.prueba.symplifica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steven.prueba.symplifica.model.User;
import com.steven.prueba.symplifica.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public Boolean deleteUserById (Integer id) {
		userRepository.deleteById(id);
		return true;
	}
	
	public List<User> getUsers () {
		List<User> users = (List<User>) userRepository.findAll();
		return users;
	} 

}
