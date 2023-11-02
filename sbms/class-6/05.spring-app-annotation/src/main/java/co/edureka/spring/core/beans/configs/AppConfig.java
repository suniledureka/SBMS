package co.edureka.spring.core.beans.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edureka.spring.core.utils.PasswordEncoder;

@Configuration
public class AppConfig {

	public AppConfig() {
		System.out.println("AppConfig :: Constructor");
	}
	
	//@Bean
	//@Bean("encoder")
	@Bean({"encoder","security"})
	public PasswordEncoder generateEncoderObject() {
		return new PasswordEncoder();
	}
}
