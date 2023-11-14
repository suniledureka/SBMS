package com.moeln.services;

public class UserService {
	public String findUserNameById(int id) {
		if(id == 101)
			return "Sanjay";
		return null;
	}
}
