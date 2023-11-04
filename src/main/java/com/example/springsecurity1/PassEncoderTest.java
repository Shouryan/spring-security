package com.example.springsecurity1;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassEncoderTest {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin123"));
		System.out.println(encoder.encode("manager123"));
		System.out.println(encoder.encode("emp123"));
		System.out.println(encoder.encode("SV123"));
		System.out.println(encoder.encode("SA123"));
	}
}
