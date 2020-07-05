package com.meinergy.springcloud.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ：Wong
 * @date ：Created in 2020/7/4 11:56
 * @description：支付实体类
 * @modified By：
 * @version:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("payment")
@ApiModel(value = "支付信息")
public class Payment implements Serializable {

    @ApiModelProperty(value = "id", notes = "id")
    @TableId("id")
    private Long id;

    @ApiModelProperty(value = "serial",notes ="serial" )
    @TableField("serial")
    private String serial;
}
