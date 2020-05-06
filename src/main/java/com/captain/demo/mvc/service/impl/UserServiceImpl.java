package com.captain.demo.mvc.service.impl;

import com.captain.demo.mvc.entity.User;
import com.captain.demo.mvc.dao.UserMapper;
import com.captain.demo.mvc.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * demo项目用户表 服务实现类
 * </p>
 *
 * @author captain
 * @since 2020-04-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
