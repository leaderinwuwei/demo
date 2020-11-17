package com.captain.demo.study.concurrency;

import com.captain.demo.common.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Captain Wang
 * @time2020/6/29
 */
@RestController
public class TestController {

    //坏味道
    @GetMapping("/synchronized")
    public synchronized Result synchronizedss() throws InterruptedException {
        Thread.sleep(9000L);
        System.out.printf("999999999999" + Thread.currentThread().getName() + "\n");
        return new Result();
    }

}
