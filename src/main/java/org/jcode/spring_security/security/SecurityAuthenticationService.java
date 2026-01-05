package org.jcode.spring_security.security;

import java.util.Optional;

import org.jcode.spring_security.entity.Users;
import org.jcode.spring_security.repo.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SecurityAuthenticationService implements UserDetailsService {

	@Autowired
	UserJpaRepository jpa;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Users> option=jpa.findById(email);
		if(option.isPresent()) {
			System.out.println("User data present");
			return option.get();
		}else {
			System.out.println("User not present");
			throw new UsernameNotFoundException("User data not present for : "+email);
		}
	}

}
