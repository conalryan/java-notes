package com.conalryan.application;

/**
 * Created by Conal on 3/15/2015.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.conalryan")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
