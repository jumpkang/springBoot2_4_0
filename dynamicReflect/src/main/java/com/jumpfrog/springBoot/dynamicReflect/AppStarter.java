package com.jumpfrog.springBoot.dynamicReflect;

import com.jumpfrog.springBoot.dynamicReflect.demos.DemoService;
import com.jumpfrog.springBoot.dynamicReflect.spring.utils.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppStarter {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(AppStarter.class, args);
        System.out.println(SpringContextUtil.getBean(SpringContextUtil.class));
        SpringContextUtil.registerBean("demoService", DemoService.class);
        DemoService service = SpringContextUtil.getBean(DemoService.class);
        System.out.println(service.get());
        Thread.sleep(1000L);
        service = SpringContextUtil.getBean("demoService");
        System.out.println(service.get());
    }
}
