package com.fss.springdemo.config.abst;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/7 21:55
 **/
public abstract class CommandManager {
    public Object process(int state) {
        Command command = createCommand();
        command.setState(1);
        return command.execute();
    }

    protected abstract Command createCommand();
}
