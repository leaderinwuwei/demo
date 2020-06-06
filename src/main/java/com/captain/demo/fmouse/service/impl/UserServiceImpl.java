package com.captain.demo.fmouse.service.impl;

import com.captain.demo.fmouse.entity.User;
import com.captain.demo.fmouse.mapper.UserMapper;
import com.captain.demo.fmouse.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * demo项目用户表 服务实现类
 * </p>
 *
 * @author captain
 * @since 2020-05-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
