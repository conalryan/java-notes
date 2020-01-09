package com.mydomain;

import org.otherdomain.Message;

/*
 * Compile with:
 * `javac HelloWorld.java`
 *
 * Run with:
 * `java com/mydomain/HelloWorld` 
 */
public class HelloWorld {

    public static void main(String[] args) {

	    Message message = new Message("Hello, World");

        // Prints "Hello, World" to the terminal window.
        System.out.println(message.getMessage());
    }
}
