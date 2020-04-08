package com.fss.springdemo.config.listen;

import org.springframework.context.ApplicationEvent;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/8 10:47
 **/
public class DemoEvent extends ApplicationEvent {
    private String text;

    public DemoEvent() {
        super("");
    }

    public DemoEvent(Object source) {
        super(source);
    }

    public DemoEvent(Object source, String text) {
        super(source);
        this.text = text;
    }

    public void print() {
        System.out.println("print event content:" + this.text);
    }

    public void setText(String text) {
        this.text = text;
    }
}
