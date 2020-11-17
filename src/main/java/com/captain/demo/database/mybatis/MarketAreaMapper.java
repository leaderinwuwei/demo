package com.captain.demo.database.mybatis;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.captain.demo.database.mybatis.entity.MarketArea;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 营销区域表 Mapper 接口
 * </p>
 *
 * @author captain
 * @since 2020-08-11
 */
public interface MarketAreaMapper extends BaseMapper<MarketArea> {
    IPage<MarketArea> lalala(IPage page);
}
