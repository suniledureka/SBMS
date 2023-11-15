package com.modeln.boot.utils;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class EncoderDecoderUtils {
	
	public EncoderDecoderUtils() {
		System.out.println("EncoderDecoderUtils :: Constructor");
	}

	public String encodeData(String data) {
		Encoder encoder = Base64.getEncoder();
		String encodedData = encoder.encodeToString(data.getBytes());
		return encodedData;
	}
	
	public String decodeData(String encodedData) {
		Decoder decoder = Base64.getDecoder();
		String data = new String(decoder.decode(encodedData));
		
		return data;
	}
	
	public void myInit() {
		System.out.println("EncoderDecoderUtils :: initialization");
	}
	
	public void myDestructor() {
		System.out.println("EncoderDecoderUtils :: destructor");
	}
}
