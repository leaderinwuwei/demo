package com.captain.demo.mvc.dao;

import com.captain.demo.mvc.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * demo项目用户表 Mapper 接口
 * </p>
 *
 * @author captain
 * @since 2020-04-25
 */
public interface UserMapper extends BaseMapper<User> {
    User getLimitOne();

}
