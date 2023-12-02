package com.modeln.graphql.query;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class Welcome {
	//@QueryMapping
	@QueryMapping(name = "welcome")
	public String welcomeQuery() {
		return "Welcome to GraphQL";
	}
}
