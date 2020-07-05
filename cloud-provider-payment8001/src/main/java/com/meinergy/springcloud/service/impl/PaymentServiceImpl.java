package com.meinergy.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meinergy.springcloud.dao.PaymentDao;
import com.meinergy.springcloud.entity.Payment;
import com.meinergy.springcloud.service.PaymentService;
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
public class PaymentServiceImpl extends ServiceImpl<PaymentDao,Payment> implements PaymentService{

    @Resource
    private PaymentDao paymentDao;

    @Override
    public Integer create(Payment payment) {
        return paymentDao.insert(payment);
    }
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.selectById(id);
    }
}
