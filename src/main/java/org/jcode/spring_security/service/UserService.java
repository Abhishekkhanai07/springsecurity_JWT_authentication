package org.jcode.spring_security.service;

import java.util.Optional;

import javax.swing.text.AbstractDocument.BranchElement;

import org.jcode.spring_security.entity.ChangePassword;
import org.jcode.spring_security.entity.LoginDto;
import org.jcode.spring_security.entity.Users;
import org.jcode.spring_security.repo.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserJpaRepository jpa;
    
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	public String createUser(Users user) {
		Optional<Users> option=jpa.findById(user.getEmail());
		if(!option.isPresent()) {
			 user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			jpa.save(user);
			
			return "User registered succesfully";
		}else {
			return "User already registered";
		}
	}
	
	public String changePassword(ChangePassword password) {
	
	 Optional<Users>	option=jpa.findById(password.getEmail());
	  
	 if(option.isPresent()) {
		 Users users=option.get();
		 users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
		 jpa.save(users);
		 return "Password Changed";
	 }else {
		 return "Invalid Email";
	 }
	}
	
	public String deleteByEmail(String email) {
		jpa.deleteById(email);
		return "Deleted";
	}
	
	public String SignInUser(LoginDto login) {
		return jpa.findById(login.getEmail()).toString();
	}
}
