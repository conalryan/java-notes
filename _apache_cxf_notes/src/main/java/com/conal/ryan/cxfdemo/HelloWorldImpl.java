package com.conal.ryan.cxfdemo;

import javax.jws.WebService;

@WebService(endpointInterface = "com.conal.ryan.cxfdemo.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

