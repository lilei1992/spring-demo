package com.fss.springdemo.config.init;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;


/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/7 21:44
 **/
@Component
public class BeanClz2 implements Lifecycle {
    @Override
    public void start() {
        System.out.println("start");
    }

    @Override
    public void stop() {
        System.out.println("stop");
    }

    @Override
    public boolean isRunning() {
        return true;
    }
}
