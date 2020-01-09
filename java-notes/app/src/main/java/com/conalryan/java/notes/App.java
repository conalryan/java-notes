package com.conalryan.java.notes;

import org.apache.commons.lang3.StringUtils;

public class App {

    private static String message = "Hello from com.conalryan.java.notes.App";

    public static void main(String[] args) {
        // commons.lang3 was defined in /feature/pom.xml but pulled in as a dependency with the feature module
        if (StringUtils.isNotBlank(message)) {
            System.out.println(message);
        }
    }
}