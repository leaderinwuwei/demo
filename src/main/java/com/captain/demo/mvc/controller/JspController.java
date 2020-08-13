package com.captain.demo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Captain Wang
 * @time2020/8/11
 */
@Controller
public class JspController {

    @GetMapping("/helloJsp")
    public String helloJsp() {
        return "index";
    }
}
