package com.meinergy.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meinergy.springcloud.entity.Payment;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao extends BaseMapper<Payment> {

}
