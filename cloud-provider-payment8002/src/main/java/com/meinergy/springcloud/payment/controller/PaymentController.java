package com.meinergy.springcloud.payment.controller;

import com.meinergy.springcloud.commons.entity.CommonResult;
import com.meinergy.springcloud.commons.entity.Payment;
import com.meinergy.springcloud.payment.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ：Wong
 * @date ：Created in 2020/7/4 12:42
 * @description：支付控制类
 * @modified By：
 * @version:
 */
@RestController
@RequestMapping("/com/meinergy/springcloud/payment")
@Slf4j
@Api(value = "支付管理",tags = "支付管理")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @ApiOperation(value = "新增支付",notes = "新增支付")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "支付信息",value = "com/meinergy/springcloud/payment",required = true,dataType = "form")
    )
    @PostMapping("/insert")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("----------------插入结果："+result);
        if(result>0){
            return new CommonResult(200,"插入数据库成功",result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @ApiOperation(value = "查询单个支付信息",notes = "查询单个支付信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "query")
    )
    @GetMapping("/get")
    public CommonResult<Payment> getPaymentById(@RequestParam(value = "id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("----------------查询结果："+payment);
        if(payment!=null){
            return new CommonResult(200,"查询成功",payment);
        }else {
            return new CommonResult(200,"查询无结果 id:"+id,null);
        }
    }
}
