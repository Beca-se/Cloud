package com.zh.learn.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * TODO
 *
 * @author ZhouHu
 * @since 2020-08-20 23:08
 **/
@RestController
@RequestMapping("/test/sf")
public class TestController {
    @Autowired
    private RouteDefinitionWriter routedefinitionWriter;

    @Autowired
    private ApplicationEventPublisher publisher;
    @Autowired
    private DefaultListableBeanFactory defaultListableBeanFactory;

    @GetMapping
    public String ste(String name) {
        return "SF";
    }

    @GetMapping("/add")
    public String addRoute() throws Exception {
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setId("TEST_AUTO");
        routeDefinition.setOrder(1);
        routeDefinition.setUri(new URI("lb://payment"));
        ArrayList<FilterDefinition> filters = new ArrayList<>();
        FilterDefinition filterDefinition = new FilterDefinition();
        filters.add(filterDefinition);
        filterDefinition.setName("StripPrefix");
        routeDefinition.setFilters(filters);
        HashMap<String, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("parts", "1");
        filterDefinition.setArgs(objectObjectHashMap);
        List<PredicateDefinition> predicates = new ArrayList<>();
        PredicateDefinition predicateDefinitio = new PredicateDefinition();
        predicates.add(predicateDefinitio);
        predicateDefinitio.setName("Path");
        objectObjectHashMap.put("pattern", "/payment/**");
        predicateDefinitio.setArgs(objectObjectHashMap);
        routeDefinition.setPredicates(predicates);

        routedefinitionWriter.save(Mono.just(routeDefinition)).subscribe();

        return "sdf";
    }


    private void refresh() {
        publisher.publishEvent(new RefreshRoutesEvent(this.routedefinitionWriter));
    }
}
