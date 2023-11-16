package com.modeln.boot.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
//@ConfigurationProperties
@ConfigurationProperties(prefix = "jdbc")
//@PropertySource(value = "classpath:dbconfig.properties")
@PropertySource(value = "dbconfig.properties")

/*
@Getter
@Setter
@ToString
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor

public class DBConnection {
	private String driverClass;
	private String url;
	//@Value("admin")
	//@Value("${user}")
	private String user;

	/*
	 * public String getUser() { return user; }
	 * 
	 * public void setUser(String user) { this.user = user; }
	 * 
	 * public String getDriverClass() { return driverClass; }
	 * 
	 * public void setDriverClass(String driverClass) { this.driverClass =
	 * driverClass; }
	 * 
	 * public String getUrl() { return url; }
	 * 
	 * public void setUrl(String url) { this.url = url; }
	 * 
	 * 
	 * @Override public String toString() { return "DBConnection [driverClass=" +
	 * driverClass + ", url=" + url + ", userName=" + user + "]"; }
	 */

}
