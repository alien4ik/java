package com.example.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:beans.xml"})
public class JavaApplication {
	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
	}
}
