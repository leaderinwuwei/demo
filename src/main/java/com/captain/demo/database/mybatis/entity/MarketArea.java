package com.captain.demo.database.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 营销区域表
 * </p>
 *
 * @author captain
 * @since 2020-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_market_area")
@ApiModel(value = "MarketArea对象", description = "营销区域表")
public class MarketArea implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "营销区域编号")
    @TableField("market_no")
    private String marketNo;

    @ApiModelProperty(value = "营销区域名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "营销区域父级")
    @TableField("parent_market_no")
    private String parentMarketNo;

    @ApiModelProperty(value = "企业微信ID")
    @TableField("qywechat_id")
    private String qywechatId;

    @ApiModelProperty(value = "区域编号   4位为一级")
    @TableField("market_code")
    private String marketCode;

    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "关联SFA的营销区域ID")
    @TableField("sfa_market_id")
    private String sfaMarketId;

    @ApiModelProperty(value = "部门类型 0:其他 1:服务处 2:大区 3:事业部 4:本部 5:组")
    @TableField("market_type")
    private Integer marketType;

    @ApiModelProperty(value = "状态 1 启用 0 禁用")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private Date updateTime;

    @TableField("a")
    private String a;

    @TableField("b")
    private String b;

    @TableField("c")
    private String c;

    @TableField("d")
    private String d;

    @TableField("e")
    private String e;

    @TableField("f")
    private String f;

}
