package com.captain.demo.fmouse.controller;


import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.captain.demo.common.enums.EnumResultCode;
import com.captain.demo.common.utils.SpringContextUtil;
import com.captain.demo.fmouse.vo.FmousePlanVO;
import com.captain.demo.database.mybatis.entity.FmousePlan;
import com.captain.demo.database.mybatis.entity.User;
import com.captain.demo.fmouse.service.IFmousePlanService;
import com.captain.demo.fmouse.service.IUserService;
import com.captain.demo.common.utils.ResponseUtil;
import com.captain.demo.common.utils.Result;
import com.github.binarywang.java.emoji.EmojiConverter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * demo项目飞鼠计划表 前端控制器
 * </p>
 *
 * @author captain
 * @since 2020-05-21
 */
@RestController
@RequestMapping("/fmouse/fmouse-plan")
@Slf4j
public class FmousePlanController {

    @Resource
    private IFmousePlanService fmousePlanService;
    @Resource
    private IUserService userService;

    private static EmojiConverter emojiConverter = EmojiConverter.getInstance();

    @PostMapping("/insert")
    public Result insert(@RequestBody FmousePlan fmousePlan) {
        User user = userService.getOne(new QueryWrapper<User>().eq("openid", fmousePlan.getOpenid()).last("limit 1"));
        Integer count = fmousePlanService.count(new QueryWrapper<FmousePlan>().eq("openid", fmousePlan.getOpenid()));
        if (count >= 5) {
            return ResponseUtil.builderResponse(EnumResultCode.SUCCESS, "大于五条");
        }
        if (Objects.nonNull(user)) {
            fmousePlan.setCreateBy("flymouse");
            fmousePlan.setStatus(1);
            fmousePlan.setPlanName(emojiConverter.toAlias(fmousePlan.getPlanName()));
            fmousePlanService.save(fmousePlan);
        }
        return ResponseUtil.builderResponse(EnumResultCode.SUCCESS);
    }

    @GetMapping("/list")
    public Result list(String openid) {
        LocalDateTime now = LocalDateTime.now();
        Date nowDay = new Date();
        List<FmousePlan> fmousePlans = fmousePlanService.list(new QueryWrapper<FmousePlan>().eq("openid", openid));
        List<Integer> fmouseDone = fmousePlans.stream().filter(v -> v.getEndTime().before(nowDay)).map(FmousePlan::getId).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(fmouseDone)) {
            fmousePlanService.removeByIds(fmouseDone);
        }
        List<FmousePlanVO> fmousePlanVOS = fmousePlans.stream().filter(v -> v.getEndTime().after(nowDay)).map(v -> {
            FmousePlanVO fmousePlanVO = new FmousePlanVO();
            LocalDateTime start = LocalDateTime.ofInstant(v.getStartTime().toInstant(), ZoneId.systemDefault());
            LocalDateTime end = LocalDateTime.ofInstant(v.getEndTime().toInstant(), ZoneId.systemDefault());
            Long son = Duration.between(start, now).toDays();
            Long mother = Duration.between(start, end).toDays();
            fmousePlanVO.setPlanName(v.getPlanName());
            if (start.isAfter(now)) {
                fmousePlanVO.setPercent("无");
            } else {
                fmousePlanVO.setPercent(String.format("%.0f", 100 * (son.doubleValue() / mother.doubleValue())));
            }
            fmousePlanVO.setRemaining(String.valueOf(mother - son));
            fmousePlanVO.setPlanName(emojiConverter.toUnicode(fmousePlanVO.getPlanName()));
            return fmousePlanVO;
        }).collect(Collectors.toList());
        return ResponseUtil.builderResponse(EnumResultCode.SUCCESS, fmousePlanVOS);
    }

    @GetMapping("/listAll")
    public Result listAll(int a) throws NoSuchFieldException, IllegalAccessException {
        List<FmousePlan> fmousePlans = fmousePlanService.list(new QueryWrapper<FmousePlan>().eq(Boolean.TRUE, "openid", "afdsa"));
        List<Map<String, Object>> maplist = fmousePlanService.listMaps();
        return ResponseUtil.builderResponse(EnumResultCode.SUCCESS, fmousePlans);
    }

    @GetMapping("/test")
    public Result<List<User>> test(String aaa) {
        log.info("aaa,{}", aaa);
        User user1 = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getWxOpenid, aaa).last("limit 1"));
        User user2 = userService.getOne(new QueryWrapper<User>().eq("wx_openid", aaa).last("limit 1"));
        Result result = new Result();
        result.setData(userService.list());
        return result;
    }

}

