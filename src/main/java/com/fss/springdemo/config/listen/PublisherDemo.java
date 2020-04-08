package com.fss.springdemo.config.listen;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/8 10:52
 **/
@Component
public class PublisherDemo implements ApplicationContextAware {

    public ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
    public void publisherEvent(ApplicationEvent event)
    {
        System.out.println("-----发送事件-----"+event);
        applicationContext.publishEvent(event);
    }

}
