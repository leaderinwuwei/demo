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
 * 
 * </p>
 *
 * @author captain
 * @since 2020-08-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_test_select_table")
@ApiModel(value="TestSelectTable对象", description="")
public class TestSelectTable implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "自增主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("col1")
    private String col1;

    @TableField("col2")
    private String col2;

    @TableField("col3")
    private String col3;

    @TableField("col4")
    private String col4;

    @TableField("col5")
    private String col5;

    @TableField("col6")
    private String col6;

    @TableField("col7")
    private String col7;

    @TableField("col8")
    private String col8;

    @TableField("col9")
    private String col9;


}
