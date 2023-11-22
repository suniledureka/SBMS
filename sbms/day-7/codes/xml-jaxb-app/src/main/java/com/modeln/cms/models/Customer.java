package com.modeln.cms.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
//@XmlRootElement(name = "modelN_customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
	@XmlElement(name = "cid")
	private Integer customerId;
	@XmlElement(name = "cname")
	private String customerName;	
	private String customerEmail;
}
