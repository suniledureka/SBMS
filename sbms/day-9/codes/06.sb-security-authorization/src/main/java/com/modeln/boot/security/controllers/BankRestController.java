package com.modeln.boot.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {
	@GetMapping("/home")
	public String homePage() {
		return "Welcome to State Bank of India";
	}

	@GetMapping("/admin")
	public String adminPage() {
		return "This page is for Administrators";
	}

	@GetMapping("/manager")
	public String managerPage() {
		return "This page is for Managers & Administrator";
	}

	@GetMapping("/clerk")
	public String clerkPage() {
		return "This page is for Clerks, Managers & Admins";
	}

	@GetMapping("/cashier")
	public String cashierPage() {
		return "This page is for any type of user";
	}

	@GetMapping("/care")
	public String customerCarePage() {
		return "Contact State Bank of India";
	}
}