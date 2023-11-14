package com.modeln.app;

import com.modeln.utils.EncoderDecoderUtils;

public class Main {

	public static void main(String[] args) {
		EncoderDecoderUtils ref = new EncoderDecoderUtils();
		
		String pass = "123Sanjay#123";
		String encodedPass = ref.encodeData(pass);
		String decodedPass = ref.decodeData(encodedPass);
		
		System.out.println(pass);
		System.out.println(encodedPass);
		System.out.println(decodedPass);

	}

}
