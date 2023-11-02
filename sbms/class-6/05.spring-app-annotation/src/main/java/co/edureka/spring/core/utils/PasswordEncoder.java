package co.edureka.spring.core.utils;

import java.util.Base64;
import java.util.Base64.Encoder;

public class PasswordEncoder {
	public String encodePassword(String pass) {
		 Encoder encoder = Base64.getEncoder();
		 String encodedPassword = encoder.encodeToString(pass.getBytes());
		 return encodedPassword;
	}
}
