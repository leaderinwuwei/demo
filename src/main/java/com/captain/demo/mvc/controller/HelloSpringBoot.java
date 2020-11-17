package com.captain.demo.mvc.controller;

import com.captain.demo.database.mongo.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.captain.demo.common.utils.HttpClientUtil.httpGet;

/**
 * @author Captain Wang
 * @time2020/4/15
 */
@Profile("aaa")
@RestController
public class HelloSpringBoot {
    private String dsafghdjhsfgadsacDAF;
    private int afsdgh;
    @Resource
    private UserRepository userRepository;

    @GetMapping("/sayHello")
    public String sayHello() {
        return userRepository.findUserByUserName("天空").getPassWord();
    }


}
