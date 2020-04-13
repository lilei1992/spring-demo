package com.fss.springdemo;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import com.fss.springdemo.config.AppConstantsConfig;
import com.fss.springdemo.util.ClasspathResourceLoader2;
import com.fss.springdemo.util.IPUtils;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.ByteArrayInputStream;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/13 20:03
 **/
@WebListener
//@Component
public class LoggingContextListener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger("ROOT");
    private static final String APP_NAME = "appName";

    private String appId = "39019";

    private Boolean logLocal = false;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        String appName = sce.getServletContext().getInitParameter(APP_NAME);
        String serverIp = IPUtils.getServerIP();

        if (StringUtils.isEmpty(appName)) {
            //throw new ExceptionInInitializerError("LoggingContextListener need ContextParam:appName!");
            appName = APP_NAME;
        }
        AppConstantsConfig.APP_NAME = appName;
        AppConstantsConfig.APP_ID = appId;

        final String logName = System.getProperty("user.dir");


        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        try {
            configurator.setContext(context);
            context.reset();

            // jdk11 不支持 无法处理
            ClasspathResourceLoader loader = new ClasspathResourceLoader();
            GroupTemplate group = new GroupTemplate(loader, Configuration.defaultConfiguration());
            String logbackPath = "com.fss.springdemo.logback.btl";
            if (logLocal) {
                logbackPath = "/com/fss/springdemo/logback_local.btl";
            }
            Template template = group.getTemplate(logbackPath);
            template.binding("LOG_HOME", logName);
            template.binding("APP_NAME", appName);
            template.binding("SERVER_IP", serverIp);

            final String config = template.render();

            if (null == config || "".equals(config)) {
                throw new Exception("Can't read logback configuration template!");
            }

            ByteArrayInputStream inputStream = new ByteArrayInputStream(config.getBytes("UTF-8"));

            try {
                configurator.doConfigure(inputStream);
            } finally {
                inputStream.close();
            }

            //configurator.registerSafeConfiguration();
            context.start();

            logger.info("yqn-logging is working!");

        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
