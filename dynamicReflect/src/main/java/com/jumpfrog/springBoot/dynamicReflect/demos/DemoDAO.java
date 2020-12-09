package com.jumpfrog.springBoot.dynamicReflect.demos;

import org.springframework.stereotype.Component;

@Component
public class DemoDAO {

    public String get(){
        return "timeStamp:" + System.currentTimeMillis();
    }

}
