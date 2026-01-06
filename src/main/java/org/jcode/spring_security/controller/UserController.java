
package org.jcode.spring_security.controller;

import java.util.Optional;

import org.jcode.spring_security.JWTUtil;
import org.jcode.spring_security.entity.ChangePassword;
import org.jcode.spring_security.entity.LoginDto;
import org.jcode.spring_security.entity.Users;
import org.jcode.spring_security.repo.UserJpaRepository;
import org.jcode.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final JWTController JWTController;


	@Autowired
	UserService service;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserJpaRepository jpa;

	@Autowired
	JWTUtil jwt;

	private Authentication authenticationToken;

    UserController(JWTController JWTController) {
        this.JWTController = JWTController;
    }
	
	@RequestMapping("/public/api/create-user")
	public String register(@RequestBody Users user) {
		return service.createUser(user);
	}
	
	@RequestMapping("api/change-password")
	public String changePassword(@RequestBody ChangePassword password) {
		
		return service.changePassword(password);
	}
	
	@RequestMapping("api/delete-id/{email}")
	public String deleteById(@PathVariable String email) {
		
	     return service.deleteByEmail(email);
	}
	
	@RequestMapping("/public/api/login-user")
	public ResponseEntity<String> SignInUser(@RequestBody LoginDto login) {
		UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword());
		
		try {
			authenticationManager.authenticate(authentication);
		}catch (BadCredentialsException e) {
			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
			.body("Invalid Exception");
		}
		
		String token = jwt.generateToken(login.getEmail());
		return ResponseEntity.ok().header("Authoration", token).body("Login Successfully");
	}
	
	
	@RequestMapping("/public/get-id/{email}")
	public  ResponseEntity<String> getById(@PathVariable String email) {
		Optional<Users> res = jpa.findById(email);
		return ResponseEntity.status(HttpStatus.FOUND).body(res.get()+" ");
	}
	
	
}
