package com.fss.springdemo.util;

import org.springframework.util.StringUtils;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/13 20:16
 **/
public class RequestHeaderContext {

    private static ThreadLocal<Request.Header> threadLocalHeaderMap = new ThreadLocal<>();

    public static Request.Header getHeaderContext() {
        return threadLocalHeaderMap.get();
    }

    public static void setHeaderContext(Request.Header headerContext) {
        threadLocalHeaderMap.set(headerContext);
    }

    public static void clear() {
        threadLocalHeaderMap.set(null);
    }

    /**
     * 如果header里没有traceid的话，则默认生成一个
     */
    public static void checkInitXtraceID() {
        if (getHeaderContext() == null) {
            setHeaderContext(TraceIdUtil.buildRequestHeader(0L,"HeaderContext",""));
        }
        if(StringUtils.isEmpty(getHeaderContext().getxTraceId())){
            setHeaderContext(TraceIdUtil.buildRequestHeader(getHeaderContext().getxUserId(),getHeaderContext().getxUserName(),getHeaderContext().getxBPId()));

        }
    }
}