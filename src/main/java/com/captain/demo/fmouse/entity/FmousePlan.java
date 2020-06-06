package com.captain.demo.fmouse.entity;

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
 * demo项目飞鼠计划表
 * </p>
 *
 * @author captain
 * @since 2020-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("d_fmouse_plan")
@ApiModel(value="FmousePlan对象", description="demo项目飞鼠计划表")
public class FmousePlan implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "小程序openid")
    @TableField("openid")
    private String openid;

    @ApiModelProperty(value = "计划名称")
    @TableField("plan_name")
    private String planName;

    @ApiModelProperty(value = "开始时间")
    @TableField("start_time")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    @TableField("end_time")
    private Date endTime;

    @ApiModelProperty(value = "身份")
    @TableField("identity")
    private String identity;

    @ApiModelProperty(value = "预估完成的小时数")
    @TableField("hours")
    private Integer hours;

    @ApiModelProperty(value = "1：有效、0：删除")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("update_time")
    private Date updateTime;

    @ApiModelProperty(value = "创建人id")
    @TableField("create_by")
    private String createBy;

    @ApiModelProperty(value = "修改人id")
    @TableField("update_by")
    private String updateBy;



}
