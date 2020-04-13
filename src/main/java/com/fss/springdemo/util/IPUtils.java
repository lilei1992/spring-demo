package com.fss.springdemo.util;

import java.net.InetAddress;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/10 3:33
 **/
public class IPUtils {
    public static String appName;
    /**
     * 获取服务器IP地址
     * @return
     */
    public static String getServerIP() {
        String serverIp = "0.0.0.0";
        try {
            serverIp = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
        }

        return serverIp;
    }
}
