package com.spring.rest.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.template.dao.MyDao;

@Service
public class MyService {

    @Autowired
    private MyDao myDao;

    public String get(String id) {        
        return myDao.get(id);
    }
}
