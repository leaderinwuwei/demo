package com.captain.demo.database.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * 用户绑定的区域表（企业微信用户，如业务员）
 * </p>
 *
 * @author captain
 * @since 2020-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user_area_info")
@ApiModel(value="UserAreaInfo对象", description="用户绑定的区域表（企业微信用户，如业务员）")
public class UserAreaInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "自增主键")
    @TableId(value = "user_area_id", type = IdType.AUTO)
    private Integer userAreaId;

    @ApiModelProperty(value = "用户ID，与用户表关联")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty(value = "企业微信用户ID")
    @TableField("qywechat_id")
    private String qywechatId;

    @ApiModelProperty(value = "小程序appid")
    @TableField("xcx_appid")
    private String xcxAppid;

    @ApiModelProperty(value = "营销区域ID")
    @TableField("market_area_id")
    private Integer marketAreaId;

    @ApiModelProperty(value = "公司ID 最上级")
    @TableField("market_company_id")
    private String marketCompanyId;

    @ApiModelProperty(value = "本部 第二级")
    @TableField("market_second_id")
    private String marketSecondId;

    @ApiModelProperty(value = "事业部 第三级")
    @TableField("market_third_id")
    private String marketThirdId;

    @ApiModelProperty(value = "大区 第四级")
    @TableField("market_fourth_id")
    private String marketFourthId;

    @ApiModelProperty(value = "服务处 第五级")
    @TableField("market_fifth_id")
    private String marketFifthId;

    @ApiModelProperty(value = "组 第六级")
    @TableField("market_sixth_id")
    private String marketSixthId;

    @ApiModelProperty(value = "是否有效 0 无效 1有效")
    @TableField("is_active")
    private Boolean isActive;


}
