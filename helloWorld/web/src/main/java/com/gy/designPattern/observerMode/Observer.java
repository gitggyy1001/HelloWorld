package com.gy.designPattern.observerMode;

/**
 * Created by hello on 2018/9/10.
 */
public interface Observer {
    public void update(Double temperature,
            Double humidity,
            String weather);
}
