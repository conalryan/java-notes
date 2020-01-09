package com.spring.rest.template.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MyDao {

    public String get(String id) {
        return "got - " + id;
    }
}