package com.captain.demo.common.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.parsers.DynamicTableNameParser;
import com.baomidou.mybatisplus.extension.parsers.ITableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;

/**
 * @author Captain Wang
 * @time2020/7/7
 */
@Configuration
public class MybatisConfig {

//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        DynamicTableNameParser dynamicTableNameParser = new DynamicTableNameParser();
//        dynamicTableNameParser.setTableNameHandlerMap(new HashMap<String, ITableNameHandler>() {{
//            put("d_fmouse_plan", (metaObject, sql, tableName) -> tableName + "_" + "111");
//        }});
//        paginationInterceptor.setSqlParserList(Collections.singletonList(dynamicTableNameParser));
//        return paginationInterceptor;
//    }

    private Object getParamValue(String title, MetaObject metaObject) {
        //获取参数
        Object originalObject = metaObject.getOriginalObject();
        JSONObject originalObjectJSON = JSON.parseObject(JSON.toJSONString(originalObject));
        JSONObject boundSql = originalObjectJSON.getJSONObject("boundSql");
        JSONObject parameterObject = boundSql.getJSONObject("parameterObject");
        return parameterObject.get(title);
    }
}
