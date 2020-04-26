package com.captain.demo.mvc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.captain.demo.mvc.entity.User;
import com.captain.demo.mvc.mapper.UserMapper;
import com.captain.demo.mvc.service.IUserService;
import com.captain.demo.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * demo项目用户表 前端控制器
 * </p>
 *
 * @author captain
 * @since 2020-04-25
 */
@Controller
@RequestMapping("/mvc/user")
public class UserController {
    @Resource
    private IUserService userService;

    @GetMapping("/list")
    @ResponseBody
    public Result list(){
        Result result = new Result<>();
        result.setData(userService.list());
        return result;
    }
}

