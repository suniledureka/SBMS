package com.modeln.boot.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "jdbc")
@Data
public class DBConnection {
	private String driverClass;
	private String url;	
	private String user;
}
