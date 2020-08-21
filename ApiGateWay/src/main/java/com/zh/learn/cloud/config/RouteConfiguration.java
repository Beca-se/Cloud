package com.zh.learn.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * 解决跨域问题
 *
 * @author ZhouHu
 * @since 2020-08-20 22:36
 **/
@Configuration
public class RouteConfiguration {
    /**
     * 这里为支持的请求头，如果有自定义的header字段请自己添加（不知道为什么不能使用*）
     */
    private static final String ALLOWED_HEADERS = "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN,token,username,client";
    private static final String ALLOWED_METHODS = "*";
    private static final String ALLOWED_ORIGIN = "*";
    private static final String ALLOWED_EXPOSE = "*";
    private static final long MAX_AGE = 18000L;
//    @Bean
    public WebFilter corsFilter() {
        return (ServerWebExchange ctx, WebFilterChain chain) -> {
            ServerHttpRequest request = ctx.getRequest();
            if (CorsUtils.isCorsRequest(request)) {
                ServerHttpResponse response = ctx.getResponse();
                HttpHeaders headers = response.getHeaders();
                headers.add("Access-Control-Allow-Origin", ALLOWED_ORIGIN);
                headers.add("Access-Control-Allow-Methods", ALLOWED_METHODS);
//                headers.add("Access-Control-Max-Age", MAX_AGE);
                headers.add("Access-Control-Allow-Headers", ALLOWED_HEADERS);
                headers.add("Access-Control-Expose-Headers", ALLOWED_EXPOSE);
                headers.add("Access-Control-Allow-Credentials", "true");
                if (request.getMethod() == HttpMethod.OPTIONS) {
                    response.setStatusCode(HttpStatus.OK);
                    return Mono.empty();
                }
            }
            return chain.filter(ctx);
        };
    }

    @Bean
    public CorsWebFilter corsWebFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();

        //1、配置跨域
        // 允许任何头
        corsConfiguration.addAllowedHeader(ALLOWED_HEADERS);
        // 允许任何方法（post、get等）
        corsConfiguration.addAllowedMethod(ALLOWED_METHODS);
        // 允许任何域名使用
        corsConfiguration.addAllowedOrigin(ALLOWED_ORIGIN);
        //允许携带cookie访问
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setMaxAge(MAX_AGE);

        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsWebFilter(source);
    }
}
