package com.fss.springdemo.config.listen;

import org.springframework.context.event.EventListener;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/8 11:08
 **/
public class EventListner {

    @EventListener
    public void doSomething(DemoEvent demoEvent){
        System.out.println("EventListner.doSomething");
        demoEvent.print();
    }
}
