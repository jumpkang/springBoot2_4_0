package com.jumpfrog.springBoot.dynamicReflect.demos;

import org.springframework.beans.factory.annotation.Autowired;

public class DemoService {

    @Autowired
    private DemoDAO dao;

    public String get(){
        return dao.get();
    }
}
