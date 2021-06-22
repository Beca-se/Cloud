package com.zh.learn.cloud.entity;

import java.time.ZonedDateTime;

/**
 * @author Administrator
 * @Class Name paymentTransaction
 * @Desc TODO
 * @create: 2021-06-15 17:51
 **/
public class PaymentTransaction {
    String name;
    private ZonedDateTime startTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("paymentTransaction{");
        sb.append("name='").append(name).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append('}');
        return sb.toString();
    }
}
