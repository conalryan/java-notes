package com.ex.bazel.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    private final static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Value("${property.sanity.check:insane}")
    private String sanity;

    @RequestMapping("/helloworld")
    public String index() {
        LOGGER.info("ENDPOINT: HelloController");
        return "Greetings from Spring Boot! " + this.sanity;
    }

}