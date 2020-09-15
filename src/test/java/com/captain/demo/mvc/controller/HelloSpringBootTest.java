package com.captain.demo.mvc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.captain.demo.common.utils.RedisUtil;
import com.captain.demo.database.mybatis.MarketAreaMapper;
import com.captain.demo.database.mybatis.entity.MarketArea;
import com.captain.demo.database.mybatis.entity.UserAreaInfo;
import com.captain.demo.fmouse.service.IMarketAreaService;
import com.captain.demo.fmouse.service.IUserAreaInfoService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;
import java.time.*;
import java.util.*;
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
    @Resource
    IMarketAreaService marketAreaService;
    @Resource
    IUserAreaInfoService userAreaInfoService;

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
//        LocalDateTime start0 = LocalDateTime.now();
//        List<MarketArea> marketAreas0 = redisUtil.lGet("AREA_MARKET_CODES",0,-1).stream().map(v -> (MarketArea)v).collect(Collectors.toList());
//        marketAreas0.stream().filter(v -> StringUtils.isNotBlank(v.getMarketCode())).filter(v -> "0001".startsWith(v.getMarketCode())).collect(Collectors.toList());
//        LocalDateTime end0 = LocalDateTime.now();
//        System.out.println("直接从redis拿取"+Duration.between(start0, end0).toMillis());

        LocalDateTime start1 = LocalDateTime.now();
        List<MarketArea> marketAreas1 = marketAreaMapper.selectList(new QueryWrapper<>());
        marketAreas1.stream().filter(v -> StringUtils.isNotBlank(v.getMarketCode())).filter(v -> "0001".startsWith(v.getMarketCode())).collect(Collectors.toList());
        LocalDateTime end1 = LocalDateTime.now();
        System.out.println("直接从mysql数据库拿取"+Duration.between(start1, end1).toMillis());
        List<MarketArea> marketAreas = marketAreaService.list(new QueryWrapper<MarketArea>().select("market_no", "parent_market_no", "market_type"));
        List<String> departments = new ArrayList<>();
        departments.add("11758");
        departments.add("11297");
        departments.add("11996");
        if (CollectionUtils.isNotEmpty(marketAreas)) {
            departments.forEach(department -> {
                UserAreaInfo userAreaInfo = new UserAreaInfo();
                Map<String, MarketArea> marketAreaMap = new HashMap<>();
                marketAreas.forEach(v -> marketAreaMap.put(v.getMarketNo(), v));
                List<MarketArea> selfMarketAreaList = new ArrayList<>();
                getSelfMarketAreas(selfMarketAreaList, marketAreaMap, department);
                for (MarketArea marketArea : selfMarketAreaList) {
                    switch (marketArea.getMarketType()) {
                        //MarketTypeEnums.OTHER.getMarketNo()
                        case 0:
                            userAreaInfo.setMarketCompanyId(marketArea.getMarketNo());
                            break;
                        //MarketTypeEnums.BASE.getMarketNo()
                        case 4:
                            userAreaInfo.setMarketSecondId(marketArea.getMarketNo());
                            break;
                        //MarketTypeEnums.BUSINESS.getMarketNo()
                        case 3:
                            userAreaInfo.setMarketThirdId(marketArea.getMarketNo());
                            break;
                        //MarketTypeEnums.DISTRICT.getMarketNo()
                        case 2:
                            userAreaInfo.setMarketFourthId(marketArea.getMarketNo());
                            break;
                        //MarketTypeEnums.SERVICE.getMarketNo()
                        case 1:
                            userAreaInfo.setMarketFifthId(marketArea.getMarketNo());
                            break;
                        //MarketTypeEnums.GROUP.getMarketNo()
                        case 5:
                            userAreaInfo.setMarketSixthId(marketArea.getMarketNo());
                            break;
                        default:
                            break;
                    }
                }
                System.out.println(userAreaInfo.toString());
                userAreaInfo.setUserId(1);
                userAreaInfoService.save(userAreaInfo);
            });
        }
//        LocalDateTime start2 = LocalDateTime.now();
//        List<MarketArea> marketAreas2 = marketAreaMapper.selectList(new QueryWrapper<MarketArea>().eq("a","0001").eq("b","0001"));
//        LocalDateTime end2 = LocalDateTime.now();
//        System.out.println("直接从数据库筛选（拆分字段，没有使用递归）"+Duration.between(start2, end2).toMillis());
    }
    private void getSelfMarketAreas(List<MarketArea> selfMarketAreaList, Map<String, MarketArea> marketAreaMap, String marketAreaNo) {
        MarketArea marketArea = marketAreaMap.get(marketAreaNo);
        selfMarketAreaList.add(marketArea);
        if (Objects.isNull(marketArea)) {
            selfMarketAreaList.remove(null);
        } else {
            if (!Objects.equals("0", marketArea.getParentMarketNo())) {
                getSelfMarketAreas(selfMarketAreaList, marketAreaMap, marketArea.getParentMarketNo());
            }
        }
    }

    @Test
    public void lalala() {
        IPage<MarketArea> page = new Page<>(1,3);
        IPage<MarketArea> iPage = marketAreaMapper.lalala(page);
        //marketAreaMapper.selectPage(page,new QueryWrapper<>());
        System.out.println("");
    }
    @Autowired
    private DataSourceTransactionManager dstManager;
    @Test
    public void dsaf() {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW); // 事物隔离级别，开启新事务，这样会比较安全些。
        TransactionStatus transaction= dstManager.getTransaction(def); // 获得事务状态
        try {
            MarketArea marketArea1 = marketAreaMapper.selectById(1);
            marketArea1.setMarketNo("11111111111111111");
            MarketArea marketArea2 = marketAreaMapper.selectById(1);
            dstManager.commit(transaction);
        }catch (Exception e) {
          dstManager.rollback(transaction);
        }

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