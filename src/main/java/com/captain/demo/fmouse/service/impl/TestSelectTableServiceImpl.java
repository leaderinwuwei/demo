package com.captain.demo.fmouse.service.impl;

import com.captain.demo.database.mybatis.entity.TestSelectTable;
import com.captain.demo.database.mybatis.TestSelectTableMapper;
import com.captain.demo.fmouse.service.ITestSelectTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author captain
 * @since 2020-08-27
 */
@Service
public class TestSelectTableServiceImpl extends ServiceImpl<TestSelectTableMapper, TestSelectTable> implements ITestSelectTableService {

}
