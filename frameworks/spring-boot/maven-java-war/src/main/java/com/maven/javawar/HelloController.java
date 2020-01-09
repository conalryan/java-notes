package com.maven.javawar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    private final static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/helloworld")
    public String index() {
        LOGGER.info("ENDPOINT: HelloController");
        return "Greetings from Spring Boot!";
    }

}