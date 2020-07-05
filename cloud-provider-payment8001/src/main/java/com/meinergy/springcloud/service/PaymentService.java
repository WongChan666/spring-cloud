package com.meinergy.springcloud.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.meinergy.springcloud.entity.Payment;

public interface PaymentService extends IService<Payment> {

    Integer create(Payment payment);

    Payment getPaymentById(Long id);

}
