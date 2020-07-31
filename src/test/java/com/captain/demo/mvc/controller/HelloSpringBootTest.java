package com.captain.demo.mvc.controller;

import com.captain.demo.common.utils.RedisUtil;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Captain Wang
 * @time2020/7/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloSpringBootTest {

    @Resource
    RedisUtil redisUtil;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void sayHello() {
        redisUtil.set("1aaa","2bbb");
    }
}