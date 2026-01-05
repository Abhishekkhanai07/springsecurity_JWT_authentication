package org.jcode.spring_security.controller;

import org.jcode.spring_security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWTController {

	@Autowired
	JWTUtil jwtutil;
	
	@PostMapping("/login/{username}")
	public String login(@PathVariable String username) {
		
		return jwtutil.generateToken(username);
		
	}
	
	@GetMapping("/get")
	public String getUserId(@RequestHeader("Authorization") String token) {
		
		return jwtutil.getUserName(token);
	}
}
