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
 * 促销员信息表
 * </p>
 *
 * @author captain
 * @since 2020-08-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("p_promoter_activity_attendance")
@ApiModel(value="PromoterActivityAttendance对象", description="促销员信息表")
public class PromoterActivityAttendance implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty(value = "方案id")
    @TableField("product_id")
    private Integer productId;

    @ApiModelProperty(value = "活动点id")
    @TableField("activity_id")
    private Integer activityId;

    @ApiModelProperty(value = "上班卡打卡时间")
    @TableField("morning_start_time")
    private Date morningStartTime;

    @ApiModelProperty(value = "上班卡打卡省")
    @TableField("morning_start_province")
    private String morningStartProvince;

    @ApiModelProperty(value = "上班卡打卡市")
    @TableField("morning_start_city")
    private String morningStartCity;

    @ApiModelProperty(value = "上班卡打卡区")
    @TableField("morning_start_area")
    private String morningStartArea;

    @ApiModelProperty(value = "上班卡打卡地址")
    @TableField("morning_start_address")
    private String morningStartAddress;

    @ApiModelProperty(value = "上班卡打卡经度")
    @TableField("morning_start_longitude")
    private String morningStartLongitude;

    @ApiModelProperty(value = "上班卡打卡纬度")
    @TableField("morning_start_latitude")
    private String morningStartLatitude;

    @ApiModelProperty(value = "上班卡打卡照照片")
    @TableField("morning_start_photo")
    private String morningStartPhoto;

    @ApiModelProperty(value = "上班卡打卡true：有效、false：无效")
    @TableField("morning_start_done")
    private Boolean morningStartDone;

    @ApiModelProperty(value = "午休下班卡打卡时间")
    @TableField("morning_end_time")
    private Date morningEndTime;

    @ApiModelProperty(value = "午休下班卡打卡省")
    @TableField("morning_end_province")
    private String morningEndProvince;

    @ApiModelProperty(value = "午休下班卡打卡市")
    @TableField("morning_end_city")
    private String morningEndCity;

    @ApiModelProperty(value = "午休下班卡打卡区")
    @TableField("morning_end_area")
    private String morningEndArea;

    @ApiModelProperty(value = "午休下班卡打卡地址")
    @TableField("morning_end_address")
    private String morningEndAddress;

    @ApiModelProperty(value = "午休下班卡打卡经度")
    @TableField("morning_end_longitude")
    private String morningEndLongitude;

    @ApiModelProperty(value = "午休下班卡打卡纬度")
    @TableField("morning_end_latitude")
    private String morningEndLatitude;

    @ApiModelProperty(value = "午休下班卡打卡照片")
    @TableField("morning_end_photo")
    private String morningEndPhoto;

    @ApiModelProperty(value = "午休下班卡打卡true：有效、false：无效")
    @TableField("morning_end_done")
    private Boolean morningEndDone;

    @ApiModelProperty(value = "午休上班卡打卡时间")
    @TableField("afternoon_start_time")
    private Date afternoonStartTime;

    @ApiModelProperty(value = "午休上班卡打卡省")
    @TableField("afternoon_start_province")
    private String afternoonStartProvince;

    @ApiModelProperty(value = "午休上班卡打卡市")
    @TableField("afternoon_start_city")
    private String afternoonStartCity;

    @ApiModelProperty(value = "午休上班卡打卡区")
    @TableField("afternoon_start_area")
    private String afternoonStartArea;

    @ApiModelProperty(value = "午休上班卡打卡地址")
    @TableField("afternoon_start_address")
    private String afternoonStartAddress;

    @ApiModelProperty(value = "午休上班卡打卡经度")
    @TableField("afternoon_start_longitude")
    private String afternoonStartLongitude;

    @ApiModelProperty(value = "午休上班卡打卡纬度")
    @TableField("afternoon_start_latitude")
    private String afternoonStartLatitude;

    @ApiModelProperty(value = "午休上班卡打卡照照片")
    @TableField("afternoon_start_photo")
    private String afternoonStartPhoto;

    @ApiModelProperty(value = "午休上班卡打卡true：有效、false：无效")
    @TableField("afternoon_start_done")
    private Boolean afternoonStartDone;

    @ApiModelProperty(value = "下班卡打卡时间")
    @TableField("afternoon_end_time")
    private Date afternoonEndTime;

    @ApiModelProperty(value = "下班卡打卡省")
    @TableField("afternoon_end_province")
    private String afternoonEndProvince;

    @ApiModelProperty(value = "下班卡打卡市")
    @TableField("afternoon_end_city")
    private String afternoonEndCity;

    @ApiModelProperty(value = "下班卡打卡区")
    @TableField("afternoon_end_area")
    private String afternoonEndArea;

    @ApiModelProperty(value = "下班卡打卡地址")
    @TableField("afternoon_end_address")
    private String afternoonEndAddress;

    @ApiModelProperty(value = "下班卡打卡经度")
    @TableField("afternoon_end_longitude")
    private String afternoonEndLongitude;

    @ApiModelProperty(value = "下班卡打卡纬度")
    @TableField("afternoon_end_latitude")
    private String afternoonEndLatitude;

    @ApiModelProperty(value = "下班卡打卡照照片")
    @TableField("afternoon_end_photo")
    private String afternoonEndPhoto;

    @ApiModelProperty(value = "下班卡打卡true：有效、false：无效")
    @TableField("afternoon_end_done")
    private Boolean afternoonEndDone;

    @ApiModelProperty(value = "true：有效、false：无效")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty(value = "true：未删除、false：删除")
    @TableField("is_deleted")
    private Boolean isDeleted;

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
