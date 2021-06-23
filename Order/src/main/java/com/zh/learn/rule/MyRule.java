package com.zh.learn.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Administrator
 * @Class Name MyRule
 * @Desc TODO
 * @create: 2021-06-23 13:58
 **/
@Component
public class MyRule extends AbstractLoadBalancerRule {

    private Logger log = LoggerFactory.getLogger(getClass());
    private Server perServer = null;
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            log.warn("no load balancer");
            return null;
        }

//        if (perServer != null && count.get() < 2 && perServer.isAlive() && perServer.isReadyToServe()) {
//            count.getAndIncrement();
//            return perServer;
//        }
        List<Server> reachableServers = lb.getReachableServers();
        if (CollectionUtils.isEmpty(reachableServers)) {
            System.out.println("xxxxxxxxxxxxx");
            return null;
        }
        perServer = reachableServers.get(0);

        return perServer;
    }

    /**
     * Inspired by the implementation of {@link AtomicInteger#incrementAndGet()}.
     *
     * @param modulo The modulo to bound the value of the counter.
     * @return The next value.
     */
    private int incrementAndGetModulo(int modulo) {
        for (; ; ) {
            int current = count.get();
            int next = (current + 1) % modulo;
            if (count.compareAndSet(current, next)) {
                return next;
            }
        }
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }
}
