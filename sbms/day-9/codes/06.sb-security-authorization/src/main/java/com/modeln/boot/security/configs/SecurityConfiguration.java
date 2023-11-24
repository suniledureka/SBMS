package com.modeln.boot.security.configs;


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
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Bean
	public SecurityFilterChain customSecurityConfiguration(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(request -> request.requestMatchers("/home","/care")
													 .permitAll()
													 .requestMatchers("/admin").hasRole("ADMIN")
													 .requestMatchers("/manager").hasAnyRole("ADMIN","MANAGER")
													 .requestMatchers("/clerk").hasAnyRole("ADMIN","MANAGER","CLERK")
													 .anyRequest()
													 .authenticated());
		http.csrf(csrf ->csrf.disable());
		http.httpBasic(Customizer.withDefaults());		
		return http.build();
	}
	
	@Bean
	public UserDetailsService configureUsers() {
		UserDetails user1 = User.withUsername("admin")
						.password("12345")
						.passwordEncoder(password -> encoder.encode(password))
						.roles("ADMIN")
						.build();
		
		var user2 = User.withUsername("manager")
						.password("12345")
						.passwordEncoder(password -> encoder.encode(password))
						.roles("MANAGER")						
						.build();
		var user3 = User.withUsername("clerk")
						.password("12345")
						.passwordEncoder(password -> encoder.encode(password))
						.roles("CLERK")						
						.build();
		
		UserDetailsManager users = new InMemoryUserDetailsManager(user1, user2, user3);
		
		return users;
	}
}
