package com.captain.demo.mvc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.captain.demo.common.utils.RedisUtil;
import com.captain.demo.database.mybatis.MarketAreaMapper;
import com.captain.demo.database.mybatis.entity.MarketArea;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Captain Wang
 * @time2020/7/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloSpringBootTest {

    @Resource
    RedisUtil redisUtil;
    @Resource
    MarketAreaMapper marketAreaMapper;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void sayHello() {
        redisUtil.set("1aaa", "2bbb");
    }

    @Test
    public void timeToGetMarketCode() {
        LocalDateTime start0 = LocalDateTime.now();
        List<MarketArea> marketAreas0 = redisUtil.lGet("AREA_MARKET_CODES",0,-1).stream().map(v -> (MarketArea)v).collect(Collectors.toList());
        marketAreas0.stream().filter(v -> StringUtils.isNotBlank(v.getMarketCode())).filter(v -> "0001".startsWith(v.getMarketCode())).collect(Collectors.toList());
        LocalDateTime end0 = LocalDateTime.now();
        System.out.println("直接从redis拿取"+Duration.between(start0, end0).toMillis());

        LocalDateTime start1 = LocalDateTime.now();
        List<MarketArea> marketAreas1 = marketAreaMapper.selectList(new QueryWrapper<>());
        marketAreas1.stream().filter(v -> StringUtils.isNotBlank(v.getMarketCode())).filter(v -> "0001".startsWith(v.getMarketCode())).collect(Collectors.toList());
        LocalDateTime end1 = LocalDateTime.now();
        System.out.println("直接从mysql数据库拿取"+Duration.between(start1, end1).toMillis());

        LocalDateTime start2 = LocalDateTime.now();
        List<MarketArea> marketAreas2 = marketAreaMapper.selectList(new QueryWrapper<MarketArea>().eq("a","0001").eq("b","0001"));
        LocalDateTime end2 = LocalDateTime.now();
        System.out.println("直接从数据库筛选（拆分字段，没有使用递归）"+Duration.between(start2, end2).toMillis());
    }

    @Test
    public void timeToGetMaketCode2() {
        List<Object> marketAreas1 = new ArrayList<>(marketAreaMapper.selectList(new QueryWrapper<>()));
        redisUtil.lSetList("AREA_MARKET_CODES",marketAreas1);
    }

    @Test
    public void transfer() {
        List<MarketArea> marketAreas = marketAreaMapper.selectList(new QueryWrapper<>());
        marketAreas.forEach(v -> {
            if (StringUtils.isNotBlank(v.getMarketCode())) {
                int a = v.getMarketCode().length();
                for (int i = 0; i < a / 4; i++) {
                    if (0 == i) {
                        v.setA(v.getMarketCode().substring(i*4,(i+1)*4));
                    }
                    if (1 == i) {
                        v.setB(v.getMarketCode().substring(i*4,(i+1)*4));
                    }
                    if (2 == i) {
                        v.setC(v.getMarketCode().substring(i*4,(i+1)*4));
                    }
                    if (3 == i) {
                        v.setD(v.getMarketCode().substring(i*4,(i+1)*4));
                    }
                    if (4 == i) {
                        v.setE(v.getMarketCode().substring(i*4,(i+1)*4));
                    }
                    if (5 == i) {
                        v.setF(v.getMarketCode().substring(i*4,(i+1)*4));
                    }
                }
                marketAreaMapper.updateById(v);
            }
        });
    }
}