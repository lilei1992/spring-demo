package com.fss.springdemo.config;

import com.fss.springdemo.config.abst.Command;
import com.fss.springdemo.config.abst.CommandManager;
import com.fss.springdemo.entity.User;
import com.fss.springdemo.util.Loggers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/7 21:30
 **/
@Component
public class AppConfig {
    static final Logger loger = LoggerFactory.getLogger(AppConfig.class);
    static final Logger MQ = LoggerFactory.getLogger("mq");
    static final Logger BIZ = LoggerFactory.getLogger("biz");
    static final Logger DB = LoggerFactory.getLogger("db");

    public static Logger getLoger() {
        return loger;
    }

    @Bean
    public User user() {
        Loggers.BIZ.info("ss");
        Loggers.BIZ.error("xxx",null);
        Loggers.MQ.info("role","exchange","queue","message","122",new Exception("haha"));
        return new User("王武", 3);
    }

    @Bean
    public Command command() {
        return new Command() {
            @Override
            public void setState(int state) {
                System.out.println("setState");
            }

            @Override
            public Object execute() {
                System.out.println("execute");
                return null;
            }
        };
    }

    @Bean
    public CommandManager commandManager() {
        return new CommandManager() {
            @Override
            protected Command createCommand() {
                System.out.println("createCommand");
                return command();
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        //User user = ctx.getBean(User.class);
        //  System.out.println(user.toString());
        // CommandManager commandManager = ctx.getBean(CommandManager.class);
        // commandManager.process(1);

    }

}
