package com.modeln.boot.security.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfiguration {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Bean
	public SecurityFilterChain customSecurityConfiguration(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(request -> request.anyRequest()
													 .authenticated());
		http.csrf(csrf ->csrf.disable());
		http.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	@Bean
	public UserDetailsService configureUsers() {
		UserDetails user1 = User.withUsername("sanjay")
						.password(encoder.encode("12345"))						
						.roles("ADMIN")
						.build();
		
		var user2 = User.withUsername("praveen")
						.password("12345")
						.passwordEncoder(pwd -> encoder.encode(pwd))
						.roles("USER")
						.build();
		
		UserDetailsManager users = new JdbcUserDetailsManager(dataSource);
		users.createUser(user1);
		users.createUser(user2);
		
		return users;
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	  return new WebMvcConfigurer() {
	    public void addCorsMappings(CorsRegistry registry) {
	      registry.addMapping("/**")
	              .allowedMethods("*")
	              .allowedOrigins("http://localhost:3000");
	  } 
	 };
	}
}
