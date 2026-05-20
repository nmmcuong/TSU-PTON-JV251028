package com.example.session11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Session11Application {

	public static void main(String[] args) {
		System.out.println("HASH THẬT LÀ: " + new BCryptPasswordEncoder().encode("password123"));
		SpringApplication.run(Session11Application.class, args);
	}

}
