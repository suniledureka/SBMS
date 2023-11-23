package com.modeln.rest.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	@Autowired
	private MessageSource msgSource;
	
	@GetMapping("/welcome")
	public String showWelcomeMessage() {
		Locale locale = LocaleContextHolder.getLocale();
		System.out.println(locale.getCountry() + " -- " + locale.getLanguage());
		
		String responseText = msgSource.getMessage("welcome.msg", null, "NA", locale);
		return responseText;
	}

}
