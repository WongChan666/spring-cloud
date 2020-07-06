package com.meinergy.cloud.controller;


import com.meinergy.springcloud.entity.CommonResult;
import com.meinergy.springcloud.entity.Payment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ：Wong
 * @date ：Created in 2020/7/4 17:34
 * @description：客户端消费Order控制层类
 * @modified By：
 * @version:
 */
@Slf4j
@RestController
@RequestMapping("/order")
@Api(value = "订单消费者order模块",tags = "订单消费者order模块")
public class OrderController {

    public static final String PAYMENT_URL ="http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @ApiOperation(value = "订单创建",notes = "订单创建")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "支付信息",value = "支付信息",required = true,dataType = "form")
    )
    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/insert",payment,CommonResult.class);
    }

    @ApiOperation(value = "订单查询",notes = "订单查询")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "query")
    )
    @GetMapping("/payment/query")
    public CommonResult<Payment> create(@RequestParam(value = "id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get?id="+id,CommonResult.class);
    }
}
