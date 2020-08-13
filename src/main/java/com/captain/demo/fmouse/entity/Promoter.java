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
@TableName("p_promoter")
@ApiModel(value="Promoter对象", description="促销员信息表")
public class Promoter implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "促销员id")
    @TableId(value = "promoter_id", type = IdType.AUTO)
    private Integer promoterId;

    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty(value = "促销员名称")
    @TableField("promoter_name")
    private String promoterName;

    @ApiModelProperty(value = "促销员性别")
    @TableField("promoter_sex")
    private String promoterSex;

    @ApiModelProperty(value = "促销员身高")
    @TableField("promoter_height")
    private Integer promoterHeight;

    @ApiModelProperty(value = "促销员手机号")
    @TableField("promoter_phone")
    private String promoterPhone;

    @ApiModelProperty(value = "促销员身份证号码")
    @TableField("promoter_id_card_no")
    private String promoterIdCardNo;

    @ApiModelProperty(value = "促销员身份证照片")
    @TableField("promoter_id_card_photo")
    private String promoterIdCardPhoto;

    @ApiModelProperty(value = "促销员地址省")
    @TableField("promoter_address_province")
    private String promoterAddressProvince;

    @ApiModelProperty(value = "促销员地址市")
    @TableField("promoter_address_city")
    private String promoterAddressCity;

    @ApiModelProperty(value = "促销员地址区")
    @TableField("promoter_address_area")
    private String promoterAddressArea;

    @ApiModelProperty(value = "促销员详细地址")
    @TableField("promoter_address_detail")
    private String promoterAddressDetail;

    @ApiModelProperty(value = "促销员地址经度")
    @TableField("promoter_address_longitude")
    private String promoterAddressLongitude;

    @ApiModelProperty(value = "促销员地址纬度")
    @TableField("promoter_address_latitude")
    private String promoterAddressLatitude;

    @ApiModelProperty(value = "促销员全身照")
    @TableField("promoter_full_photo")
    private String promoterFullPhoto;

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
