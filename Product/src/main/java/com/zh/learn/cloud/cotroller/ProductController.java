package com.zh.learn.cloud.cotroller;

import com.zh.learn.cloud.entity.PaymentTransaction;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @Class Name PaymentController
 * @Desc TODO
 * @create: 2021-06-18 13:47
 **/
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @GetMapping
    public String get(String name) {
        return "product";
    }

    @PostMapping
    public String post(@RequestBody PaymentTransaction paymentTransaction) {
        return paymentTransaction.toString();
    }
}
