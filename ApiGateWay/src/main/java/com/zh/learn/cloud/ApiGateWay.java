package com.zh.learn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 * @Class Name ApiGateWay
 * @Desc 1. 请求黑白名单
 * 2. 登陆认证(权限校验)
 * 3. 参数校验
 * 4. 日志记录
 * 5. 链路埋点追踪
 * @create: 2020-08-20 17:39
 **/
@SpringBootApplication
public class ApiGateWay {

    public static void main(String[] args) {

        SpringApplication.run(ApiGateWay.class, args);
    }
}
