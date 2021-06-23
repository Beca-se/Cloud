package com.zh.learn.cloud.feign;

import com.zh.learn.cloud.entity.PaymentTransaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Class Name PaymentFeign
 * @Desc
 * @create: 2021-06-21 16:32
 **/
@FeignClient(value = "product")
public interface ProductFeign {
    List<String> ad = new ArrayList<String>();

    @GetMapping("/api/v1/product")
    String hello(@RequestParam("name") String name);

    @PostMapping("/api/v1/product")
    String test(@RequestBody PaymentTransaction paymentTransaction);
}
