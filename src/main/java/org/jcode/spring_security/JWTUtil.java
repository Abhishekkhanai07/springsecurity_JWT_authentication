package org.jcode.spring_security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {

	
	private String SECRET_KEY="mysecretkey12345mysecretkey12345mysecretkey12345mysecretkey12345";
	
	private Key keys=Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	
	public String generateToken(String name) {
		return Jwts.builder().setSubject(name)
				.signWith(keys).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+2*60*1000))
				.compact();
	}
	
	public String getUserName(String token) {
		return Jwts.parserBuilder().setSigningKey(keys).build()
				.parseClaimsJws(token).getBody().getSubject();
	}
	
	public boolean isValid(String token) {
		return Jwts
				.parserBuilder()
				.setSigningKey(keys)
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getExpiration()
				.after(new Date());
	}
	
	public boolean validate(String token,String name) {
		String username=getUserName(token);
		
		return username.equalsIgnoreCase(name) && isValid(token);
	}
}
