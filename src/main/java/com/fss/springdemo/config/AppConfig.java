package com.fss.springdemo.config;

import com.fss.springdemo.config.abst.Command;
import com.fss.springdemo.config.abst.CommandManager;
import com.fss.springdemo.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/7 21:30
 **/
@Component
public class AppConfig {
    @Bean
    public User user() {
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
