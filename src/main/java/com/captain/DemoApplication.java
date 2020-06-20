package com.captain;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Captain Wang
 * @time2020/4/15
 */
@Slf4j
@SpringBootApplication  // same as @Configuration @EnableAutoConfiguration @ComponentScan
@MapperScan("com.captain.demo.database.mybatis")
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
