package com.fss.springdemo.config.listen;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/8 10:46
 **/
@Component
public class PrintListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        System.out.println("onApplicationEvent PrintListener");
        demoEvent.print();
    }
}
