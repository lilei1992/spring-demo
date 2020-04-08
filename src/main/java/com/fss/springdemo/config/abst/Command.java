package com.fss.springdemo.config.abst;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/7 21:57
 **/
public interface Command {

    void setState(int state);

    Object execute();

}
