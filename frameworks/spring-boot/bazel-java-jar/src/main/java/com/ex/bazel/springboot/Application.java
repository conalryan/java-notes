package com.ex.bazel.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  final static Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
    LOGGER.debug("Standard Slf4j log level"); // Standard Slf4j log level
		SpringApplication.run(Application.class, args);
	}

}
