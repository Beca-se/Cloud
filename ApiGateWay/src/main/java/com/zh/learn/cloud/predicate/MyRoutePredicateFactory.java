//package com.zh.learn.cloud.predicate;
//
//import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
//import org.springframework.cloud.gateway.handler.predicate.HeaderRoutePredicateFactory;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.web.server.ServerWebExchange;
//
//import java.util.function.Predicate;
//
///**
// * TODO
// *
// * @author ZhouHu
// * @since 2020-08-20 23:33
// **/
//public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<HeaderRoutePredicateFactory.Config> {
//
//    public MyRoutePredicateFactory() {
//        super(HeaderRoutePredicateFactory.Config.class);
//    }
//
//    @Override
//    public Predicate<ServerWebExchange> apply(HeaderRoutePredicateFactory.Config config) {
//        // grab configuration from Config object
//        return exchange -> {
//            //grab the request
//            ServerHttpRequest request = exchange.getRequest();
//            //take information from the request to see if it
//            //matches configuration.
//            return matches(config, request);
//        };
//    }
//
//
//    public static class Config {
//        //Put the configuration properties for your filter here
//    }
//
//}