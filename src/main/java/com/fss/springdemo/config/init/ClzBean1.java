package com.fss.springdemo.config.init;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/7 21:41
 **/
@Component
public class ClzBean1 implements DisposableBean {
    private String destroy;

    @Override
    public void destroy() throws Exception {
        destroy = "destroy";
    }
}
