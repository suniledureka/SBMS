package com.modeln.cms.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class Customer {
	@JsonProperty(value = "cid")
	private Integer customerId;
	
	@JsonProperty("cname")
	private String customerName;
	
	//@JsonProperty(value = "email")
	private String customerEmail;
}
