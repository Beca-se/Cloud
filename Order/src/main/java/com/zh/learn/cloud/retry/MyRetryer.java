package com.zh.learn.cloud.retry;

import feign.RetryableException;
import feign.Retryer;

/**
 * @author Administrator
 * @Class Name MyRetryer
 * @Desc 重试机制(目前的机制是重试几次, 每次间隔多长时间)
 * @create: 2021-06-22 13:58
 **/
public class MyRetryer implements Retryer {

    private int count;
    private long interval;

    public MyRetryer() {
        this(3, 100);
    }

    public MyRetryer(int count, long interval) {
        this.count = count;
        this.interval = interval;
    }

    /**
     * 核心方法,如果抛出{@link RetryableException} 则不继续重试
     *
     * @param e
     */
    @Override
    public void continueOrPropagate(RetryableException e) {
        if (count-- <= 0) {
            throw e;
        }
        try {
            Thread.sleep(interval);
        } catch (Exception ex) {
            throw e;
        }

    }

    /**
     * 每一个feign 都会clone一个.
     */
    @Override
    public Retryer clone() {
        return new MyRetryer(count, interval);
    }
}
