package com.zh.learn.eureka.eureka.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author ZhouHu
 * @Class Name WebSecurityConfig
 * @Desc Spring Security 默认开启了跨域保护(CSRF),我们需要关闭以方便Eureka Client注册到我们的Eureka Server上面
 * @create: 2020-03-19 09:24
 **/
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭 CSRF
        http.csrf().disable();
        // 开启安全认证
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }

}