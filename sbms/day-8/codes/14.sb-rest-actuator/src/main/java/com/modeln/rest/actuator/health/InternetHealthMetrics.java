package com.modeln.rest.actuator.health;

import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class InternetHealthMetrics implements HealthIndicator {

	@Override
	public Health health() {
		Health healthObj = checkInternetConnection()?Health.up().withDetail("Internet Connection", "Active").build()
								 :Health.down().withDetail("Internet Connection", "In-Active").build();
		return healthObj;
	}

	private boolean checkInternetConnection() {
		try {
			URL url = new URL("https://www.google.com");
			URLConnection uCon = url.openConnection();
			uCon.connect();
			return true;
		}catch(Exception ex) {}
		return false;
	}
}
