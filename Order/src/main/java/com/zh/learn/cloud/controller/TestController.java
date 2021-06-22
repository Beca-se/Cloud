package com.zh.learn.cloud.controller;

import com.zh.learn.cloud.entity.PaymentTransaction;
import com.zh.learn.cloud.feign.PaymentFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

/**
 * @author Administrator
 * @Class Name TestController
 * @Desc TODO
 * @create: 2021-06-21 17:09
 **/
@RestController
@RequestMapping("/api/v1/order")
public class TestController {

    @Autowired
    private PaymentFeign paymentFeign;


    @GetMapping
    public String hello() {
        String order = paymentFeign.hello("Order");
        return order;
    }

    @GetMapping("/post")
    public String test() {
        PaymentTransaction paymentTransaction=new PaymentTransaction();
        paymentTransaction.setStartTime(ZonedDateTime.now());
        paymentTransaction.setName("test");
        String order = paymentFeign.test(paymentTransaction);
        return order;
    }
}
