package com.zh.learn.eureka.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ZhouHu
 * @Class Name EurekaOneApplication
 * @Desc 程序启动类
 * @create: 2020-03-18 23:57
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaOneApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaOneApplication.class, args);
    }
}
