package com.example.mavenjavajar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MavenJavaJarApplication {

	public static void main(String[] args) {
    System.out.println("[APP] Starting main");
		SpringApplication.run(MavenJavaJarApplication.class, args);
    System.out.println("[APP] After SpringApplication.run");
	}
}
