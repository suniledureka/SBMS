package co.edureka.spring.core.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean(value = "user", initMethod = "myInit1", destroyMethod = "myDestructor")
	public User getUser() {
		return new User();
	}
}
