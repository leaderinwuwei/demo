package com.captain.demo.fmouse.service.impl;

import com.captain.demo.database.mybatis.entity.UserAreaInfo;
import com.captain.demo.database.mybatis.UserAreaInfoMapper;
import com.captain.demo.fmouse.service.IUserAreaInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户绑定的区域表（企业微信用户，如业务员） 服务实现类
 * </p>
 *
 * @author captain
 * @since 2020-09-04
 */
@Service
public class UserAreaInfoServiceImpl extends ServiceImpl<UserAreaInfoMapper, UserAreaInfo> implements IUserAreaInfoService {

}
