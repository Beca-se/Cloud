package com.zh.learn.cloud.filter;

import com.google.gson.Gson;
import com.zh.learn.cloud.domain.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


/**
 * 认证token
 *
 * @author ZhouHu
 * @RefreshScope 是用来动态刷新配置参数的注解
 * @since 2020-08-26 16:07
 **/
@Configuration
@RefreshScope
public class AuthFilter implements Ordered, GlobalFilter {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private static final String TOKEN_NAME = "authToken";

    private static final AntPathMatcher UAL_MATCHER = new AntPathMatcher();
    private static final Gson GSON = new Gson();
    @Value("#{'${auto.white.list:}'.split(',')}")
    private List<String> whiteList = new ArrayList<>();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 校验是否在白名单
        if (checkWhiteList(exchange.getRequest().getPath().value())) {
            return chain.filter(exchange);
        }
        // 校验token
        String token = getToken(exchange);
        if (token == null || token.isEmpty()) {
            return authError(exchange.getResponse());
        }

        if (!checkToken(token)) {
            return authError(exchange.getResponse());
        }
        return chain.filter(exchange);
    }

    /**
     * 认证错误输出
     *
     * @param resp 响应对象
     */
    private Mono<Void> authError(ServerHttpResponse resp) {
        resp.setStatusCode(HttpStatus.UNAUTHORIZED);
        resp.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(HttpStatus.UNAUTHORIZED.value());
        resultBean.setMessage("未认证!请重新登录");
        String returnStr = GSON.toJson(resultBean);
        DataBuffer buffer = resp.bufferFactory().wrap(returnStr.getBytes(StandardCharsets.UTF_8));
        return resp.writeWith(Flux.just(buffer));
    }

    private String getToken(ServerWebExchange exchange) {
        return exchange.getRequest().getQueryParams().getFirst(TOKEN_NAME);
    }

    private boolean checkToken(String token) {
        if (token.length() > 5) {
            return true;
        }
        return false;
    }

    private boolean checkWhiteList(String path) {
        for (String s : whiteList) {
            if (UAL_MATCHER.match(s, path)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
