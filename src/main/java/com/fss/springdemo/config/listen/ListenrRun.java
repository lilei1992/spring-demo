package com.fss.springdemo.config.listen;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/8 10:57
 **/
public class ListenrRun {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        PublisherDemo publisherDemo = context.getBean(PublisherDemo.class);
        DemoEvent event = context.getBean(DemoEvent.class);
        event.setText("xxx");
        publisherDemo.publisherEvent(event);
    }
}
