package com.fss.springdemo.config.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/7 21:38
 **/
@Component
public class ClzBean implements InitializingBean {
    private String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
        setName("三个");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
