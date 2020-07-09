package com.meinergy.springcloud.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author WongChan
 * @since 2020-07-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="User对象", description="用户对象")
public class User extends Model {

    private static final long serialVersionUID=1L;

    @TableId(value = "u_id", type = IdType.UUID)
    private Integer uId;

    private String uName;

    private String uPwd;

    private Integer uAge;

    private String uDescribe;

    private String uPhone;


}
