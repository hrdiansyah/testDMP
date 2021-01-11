//package com.learning.restapi.service;
//
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.learning.restapi.model.user;
//import com.learning.restapi.repository.UserRepository;
//
//@Service
//public class UserService {
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	
////	  @Autowired
////	    public UserService(UserRepository userRepository,
////	                       BCryptPasswordEncoder bCryptPasswordEncoder) {
////	        this.userRepository = userRepository;
////	        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
////	    }
//	
//	public user findByUsername(String username) {
//		return userRepository.findByUserName(username);
//	}
//	
//	public user saveAllUsers(user User) {
//		User.setId(UUID.randomUUID().toString());
//		User.setPassword(bCryptPasswordEncoder.encode(User.getPassword()));
//		return userRepository.save(User);
//	}
//	
//}
