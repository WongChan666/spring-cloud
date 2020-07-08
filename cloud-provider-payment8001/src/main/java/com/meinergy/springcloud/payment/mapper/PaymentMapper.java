package com.meinergy.springcloud.payment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meinergy.springcloud.commons.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {

}
