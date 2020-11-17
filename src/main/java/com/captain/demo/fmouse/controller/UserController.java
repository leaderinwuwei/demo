package com.captain.demo.fmouse.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.captain.demo.common.annotation.ParamCheck;
import com.captain.demo.common.constant.XcxConst;
import com.captain.demo.common.enums.EnumResultCode;
import com.captain.demo.database.mybatis.entity.User;
import com.captain.demo.fmouse.service.IUserService;
import com.captain.demo.common.utils.ResponseUtil;
import com.captain.demo.common.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * demo项目用户表 前端控制器
 * </p>
 *
 * @author captain
 * @since 2020-05-21
 */
@RestController
@RequestMapping("/fmouse/user")
public class UserController {
    @Resource
    private IUserService userService;
    @Resource
    RestTemplate restTemplate;

    @GetMapping("/login")
    public Result<User> login(@ParamCheck String code, HttpSession session, HttpServletResponse response) {
        String url = XcxConst.URL_CODE2SESSION.replace("JSCODE", code);
        String body = restTemplate.getForEntity(url, String.class).getBody();
        if (StringUtils.isBlank(body)) {
            return ResponseUtil.exception();
        }
        JSONObject bodyJson = JSON.parseObject(body);
        Integer errcode = bodyJson.getInteger("errcode");
        if (errcode != null) {
            return ResponseUtil.builderErrResponse(errcode, bodyJson.getString("errmsg"));
        }
        String openid = bodyJson.getString("openid");

        User user = userService.getOne(new QueryWrapper<User>().eq("openid", openid).last("limit 1"));
        if (user == null) {
            user = new User();
            user.setOpenid(openid);
            user.setStatus(1);
            user.setCreateBy("flymouse");
            userService.save(user);
        }
        return ResponseUtil.builderResponse(EnumResultCode.SUCCESS, user);
    }

}

