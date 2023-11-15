package com.modeln.boot.beans.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.modeln.boot.utils.EncoderDecoderUtils;

@Configuration
public class AppConfig {

	public AppConfig() {
		System.out.println("AppConfig :: Constructor");
	}
	
	//@Bean
	//@Bean(value = "security")
	//@Bean(value = {"security", "encoder"})
	@Bean(value = {"security", "encoder"}, initMethod = "myInit", destroyMethod = "myDestructor")
	public EncoderDecoderUtils generateEncoder() {
		return new EncoderDecoderUtils();
	}
}
