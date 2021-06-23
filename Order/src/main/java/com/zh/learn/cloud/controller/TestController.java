package com.zh.learn.cloud.controller;

import com.zh.learn.cloud.entity.PaymentTransaction;
import com.zh.learn.cloud.feign.PaymentFeign;
import com.zh.learn.cloud.feign.ProductFeign;
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

    @Autowired
    private ProductFeign productFeign;


    @GetMapping("/product")
    public String hello1() {
        String order = productFeign.hello("Order");
        return order;
    }

    @GetMapping("/product/post")
    public String test1() {
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setStartTime(ZonedDateTime.now());
        paymentTransaction.setName("test");
        String order = productFeign.test(paymentTransaction);
        return order;
    }

    @GetMapping("/payment")
    public String hello() {
        String order = paymentFeign.hello("Order");
        return order;
    }

    @GetMapping("//payment/post")
    public String test() {
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setStartTime(ZonedDateTime.now());
        paymentTransaction.setName("test");
        String order = paymentFeign.test(paymentTransaction);
        return order;
    }
}
