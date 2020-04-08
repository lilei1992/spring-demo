package com.fss.springdemo.config.listen;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/8 10:56
 **/
@Configuration
@Import(value = {DemoEvent.class, PrintListener.class, PublisherDemo.class, EventListner.class})
public class Config {
}
