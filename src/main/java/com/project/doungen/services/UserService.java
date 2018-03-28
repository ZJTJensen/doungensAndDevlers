package com.project.doungen.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.doungen.models.User;
import com.project.doungen.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	private BCryptPasswordEncoder bcrypt;
		
	public UserService(UserRepository userRepository){
		this.userRepository = userRepository;
		this.bcrypt = new BCryptPasswordEncoder();
	}

	public boolean isMatch(String password, String dbpass){
		if( bcrypt.matches(password, dbpass) ){
			return true;
		}
		return false;
	}

	public void create(User user){
		System.out.println("Your user is 1" + user.getPassword());
		user.setPassword(bcrypt.encode(user.getPassword()));
		List<User>users =(List<User>) userRepository.findAll();
		if(users.size() > 0 ){
			System.out.println(user);
			// user.setAdmin(2);
		}else{
			user.setAdmin(1);
		}
		userRepository.save(user);
		
	}
	public ArrayList<User> all(){
		return (ArrayList<User>)userRepository.findAll();
	}
	public void update(User user){
		create(user);
	}
	public User findById(Long id){
		return (User)userRepository.findOne(id);
	}
	public void destroy(User user){
		userRepository.delete(user);
	}
	public User findByEmail(String email){
		return (User)userRepository.findByEmail(email);
	}
	public User findByUsername(String username){
		return (User)userRepository.findByUsername(username);
	}
}
