package com.modeln.boot.security.configs;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
public class JwtSecurityConfig {
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(request ->{ 
			request.anyRequest().authenticated();
		});
		
		http.csrf().disable();
		http.headers().frameOptions().sameOrigin();
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));			
		http.httpBasic();
		http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
		return http.build();
	}	
	
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabase ds = new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
				.build();
		
		return ds;
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		var admin = User.withUsername("admin")
						.password(encoder.encode("password"))
						.roles("ADMIN", "USER") 
						.build();
		
		var user =  User.withUsername("sunil")
				.password("12345")
				.passwordEncoder(pwd -> encoder.encode(pwd))				
				.roles("USER") 
				.build();
		
		UserDetailsManager users =  new JdbcUserDetailsManager(dataSource());
		users.createUser(admin);
		users.createUser(user);
		
		return users;
	}	

	@Bean
	public KeyPair keyPair() {
	 try {
	   var keyPairGenerator = KeyPairGenerator.getInstance("RSA");
	   keyPairGenerator.initialize(2048); //2048 - keysize 2MB RSA Encryption
	   return keyPairGenerator.generateKeyPair();
	 } catch (Exception ex) {
		throw new RuntimeException(ex);
	 }
	}
	
	@Bean
	public RSAKey rsaKey(KeyPair keyPair) { //keyPair bean is autowired
	 return new RSAKey.Builder((RSAPublicKey)keyPair.getPublic())
			.privateKey(keyPair.getPrivate())
			.keyID(UUID.randomUUID().toString())
			.build();
	}
	
	@Bean
	public JWKSource<SecurityContext> jwkSource(RSAKey rsaKey) {
	  var jwkSet = new JWKSet(rsaKey);
	 
	  return (jwkSelector, context) ->  jwkSelector.select(jwkSet);
	}
	
	@Bean
	public JwtDecoder jwtDecoder(RSAKey rsaKey) throws JOSEException {
	  return NimbusJwtDecoder.withPublicKey(rsaKey.toRSAPublicKey())
				.build();
	}
	
	@Bean
	public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {
	 return new NimbusJwtEncoder(jwkSource);
	} 
}
