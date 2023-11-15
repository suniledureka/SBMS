package com.modeln.spring.core.beans.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessServices {
	@Autowired
	private Service1 ser1;
	@Autowired
	private Service2 ser2;
	
	public BusinessServices() {
		System.out.println("no arguments constructor");
	}
	//@Autowired
	public BusinessServices(Service1 ser1, Service2 ser2) {
		System.out.println("inside 2 args constructor");
		this.ser1 = ser1;
		this.ser2 = ser2;
	}

	public Service1 getSer1() {
		
		return ser1;
	}
	//@Autowired
	public void setSer1(Service1 ser1) {
		System.out.println("inside setSer1()");
		this.ser1 = ser1;
	}
	
	
	public Service2 getSer2() {
		return ser2;
	}
	//@Autowired
	public void setSer2(Service2 ser2) {
		System.out.println("inside setSer2()");
		this.ser2 = ser2;
	}

	@Override
	public String toString() {
		return "BusinessServices [ser1=" + ser1 + ", ser2=" + ser2 + "]";
	}

}
