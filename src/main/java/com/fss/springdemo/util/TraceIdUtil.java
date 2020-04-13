package com.fss.springdemo.util;

import com.dianping.cat.Cat;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/13 20:17
 **/
public class TraceIdUtil {

    /**
     * 构建Header
     * @return
     */
    public static Request.Header buildRequestHeader() {
        Long userId = 1L;
        String userName = "系统";
        String bpId = "1";

        return buildRequestHeader(userId, userName, bpId);
    }

    /**
     * 构建Header
     * @param userId
     * @param userName
     * @param bpId
     * @return
     */
    public static Request.Header buildRequestHeader(Long userId, String userName, String bpId) {
        return buildRequestHeader(userId, userName, bpId, null);
    }

    /**
     * 构建Header
     * @param userId
     * @param userName
     * @param bpId
     * @param traceId
     * @return
     */
    public static Request.Header buildRequestHeader(Long userId, String userName, String bpId, String traceId) {
        Request.Header header = new Request.Header();
        header.setxUserId(userId);
        header.setxUserName(userName);
        header.setxBPId(bpId);

        //YqnCatContext
        YqnCatContext yqnCatContext = null;

        if (StringUtils.isEmpty(traceId)) {
            yqnCatContext = getYqnCatContext();
        } else {
            yqnCatContext = new YqnCatContext();
            yqnCatContext.addProperty(Cat.Context.ROOT, traceId);
        }

        header.setYqnCatContext(yqnCatContext);

        //traceId
        header.setxTraceId(getTraceId(yqnCatContext));

        return header;
    }



    /**
     * 获取YqnCatContext
     * @return
     */
    public static YqnCatContext getYqnCatContext() {
        Request.Header header = RequestHeaderContext.getHeaderContext();
        YqnCatContext yqnCatContext = header != null ? header.getYqnCatContext() : new YqnCatContext();
        if (yqnCatContext.getProperties() != null && yqnCatContext.getProperties().size() > 0) {
            return yqnCatContext;
        }

        Cat.logRemoteCallClient(yqnCatContext);

        return yqnCatContext;
    }





    /**
     * 获取traceId
     * @return
     */
    public static String getTraceId() {

        YqnCatContext yqnCatContext = getYqnCatContext();

        return getTraceId(yqnCatContext);
    }

    /**
     * 获取traceId
     * @param yqnCatContext
     * @return
     */
    public static String getTraceId(YqnCatContext yqnCatContext) {
        if (yqnCatContext == null) {
            yqnCatContext = getYqnCatContext();
        }

        String traceId = "";
        if (yqnCatContext == null || yqnCatContext.getProperty(Cat.Context.ROOT) == null) {
            traceId = UUID.randomUUID().toString();
        } else {
            traceId = yqnCatContext.getProperty(Cat.Context.ROOT);
        }

        return traceId;
    }
}