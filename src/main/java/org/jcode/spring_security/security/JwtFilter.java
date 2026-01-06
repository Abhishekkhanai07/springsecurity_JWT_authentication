package org.jcode.spring_security.security;

import java.io.IOException;

import org.jcode.spring_security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{

	@Autowired
	JWTUtil jwtUtil;
	
	
	@Autowired
	SecurityAuthenticationService securityAuthenticationService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println(" Get the token from the Client");
		String jwtToken=request.getHeader("Authorization");
		String email=null;
		if(jwtToken!=null && !jwtToken.isBlank() && !jwtToken.isEmpty()) {
			System.out.println("Once per Request Token : Is present : Valid Token "+jwtToken);
			
			email=jwtUtil.getUserName(jwtToken);
			System.out.println("Once per Request Token : data : "+email);
		}else {
			System.out.println("Once per Request Token : Invalid Token : Add token "+email);
		}
		
		if(email!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			System.out.println("Once per Request Loading Data from Data base "+email);
			
            UserDetails userdetials=securityAuthenticationService.loadUserByUsername(email);
            
            boolean isValidToken=jwtUtil.validate(jwtToken, userdetials.getUsername());
            System.out.println("Once per Request Filter : Is Valid token "+isValidToken);
            
            if(isValidToken) {
            	UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userdetials,null,userdetials.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }else {
            	System.out.println("Invalid Token Check Jwt Token "+jwtToken);
            }
		}
		filterChain.doFilter(request, response);
		
	}

}
