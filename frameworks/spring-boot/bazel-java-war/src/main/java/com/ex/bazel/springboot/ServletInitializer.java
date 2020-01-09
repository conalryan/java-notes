package com.ex.bazel.springboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
// Spring-boot v2
// import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
// Spring-boot v1
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

}
