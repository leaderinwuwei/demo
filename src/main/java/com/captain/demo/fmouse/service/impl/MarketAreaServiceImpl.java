package com.captain.demo.fmouse.service.impl;

import com.captain.demo.database.mybatis.entity.MarketArea;
import com.captain.demo.database.mybatis.MarketAreaMapper;
import com.captain.demo.fmouse.service.IMarketAreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 营销区域表 服务实现类
 * </p>
 *
 * @author captain
 * @since 2020-08-11
 */
@Service
public class MarketAreaServiceImpl extends ServiceImpl<MarketAreaMapper, MarketArea> implements IMarketAreaService {

}
