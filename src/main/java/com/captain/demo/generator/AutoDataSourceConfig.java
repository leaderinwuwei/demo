/**
 * pxys
 * Copyright (C) 2017-2019 All Rights Reserved.
 */
package com.captain.demo.generator;


import lombok.Builder;
import lombok.Data;

/**
 * @author captainwang
 */
@Data
@Builder
public class AutoDataSourceConfig {
    private String jdbcUrl;
    private String jdbcDriverClassName;
    private String jdbcUserName;
    private String jdbcPassword;
}