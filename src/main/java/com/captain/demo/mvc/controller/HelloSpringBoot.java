package com.captain.demo.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Captain Wang
 * @time2020/4/15
 */
@RestController
public class HelloSpringBoot {
    @GetMapping("sayHello")
    public String sayHello(){
        return "hello Spring-Boot";
    }
}
