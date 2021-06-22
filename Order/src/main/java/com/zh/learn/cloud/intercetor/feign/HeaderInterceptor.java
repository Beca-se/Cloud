package com.zh.learn.cloud.intercetor.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author Administrator
 * @Class Name HeaderInterceptor
 * @Desc TODO
 * @create: 2021-06-22 14:19
 **/
public class HeaderInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        template.header("ZHOUHU_TETS", "TEST");
    }
}
