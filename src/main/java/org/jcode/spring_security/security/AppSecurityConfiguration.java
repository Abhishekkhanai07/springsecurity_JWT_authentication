package org.jcode.spring_security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class AppSecurityConfiguration {

	
	
	
	@Autowired
	JwtFilter jwtfilter;
	
	@Bean
	public SecurityFilterChain getSecurityChain(HttpSecurity httpSecurity) throws Exception {
		
		System.out.println("App Security Configuartion rules : " );
		return httpSecurity.csrf(csrf->csrf.disable()).
		cors(cors->cors.disable())
		.authorizeHttpRequests(reqs->reqs.requestMatchers("/public/**")
				.permitAll()
				.anyRequest()
				.authenticated())
		       .addFilterBefore(this.jwtfilter, UsernamePasswordAuthenticationFilter.class)
		      .build();
	}
	
	@Bean
	BCryptPasswordEncoder getBCrypPassword(){
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager getAuthenticationManager(AuthenticationConfiguration configuration) throws Exception
	{
		return configuration.getAuthenticationManager();
	}
	
}
