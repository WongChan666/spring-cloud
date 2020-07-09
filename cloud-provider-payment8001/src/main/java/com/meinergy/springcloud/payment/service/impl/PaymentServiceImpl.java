package com.meinergy.springcloud.payment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meinergy.springcloud.commons.entity.Payment;
import com.meinergy.springcloud.payment.mapper.PaymentMapper;
import com.meinergy.springcloud.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：Wong
 * @date ：Created in 2020/7/4 12:24
 * @description：支付服务实现类
 * @modified By：
 * @version:
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper,Payment> implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public Integer create(Payment payment) {
        return paymentMapper.insert(payment);
    }
    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.selectById(id);
    }

}
