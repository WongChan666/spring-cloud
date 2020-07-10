package com.meinergy.springcloud.commons.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：Wong
 * @date ：Created in 2020/7/4 11:58
 * @description：通用json返回类型
 * @modified By：
 * @version:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "统一返回json对象")
public class CommonResult<T> {

    @ApiModelProperty(value = "code",notes = "响应编码")
    private Integer code;

    @ApiModelProperty(value = "message",notes = "提示消息")
    private String message;

    @ApiModelProperty(value = "data",notes = "响应数据")
    private T data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
