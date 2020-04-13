package com.fss.springdemo.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/13 20:16
 **/
@ApiModel(value = "Request", description = "Request对象")
public class Request<T> implements Serializable {

    /**
     * Header
     */
    @ApiModelProperty(value = "Request header对象")
    private Header header = new Header();
    /**
     * 业务参数对象
     */
    @ApiModelProperty(value = "业务入参对象")
    protected T model;


    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }


    @ApiModel(value = "Request Header", description = "Request Header")
    public static class Header implements Serializable {
        @ApiModelProperty(value = "accessToken")
        private String accessToken;

        @ApiModelProperty(value = "是否展示所有")
        private Boolean viewAll;

        @ApiModelProperty(value = "用户ID")
        private Long xUserId;

        @ApiModelProperty(value = "用户名")
        private String xUserName;

        @ApiModelProperty(value = "xBPId")
        private String xBPId;

        @ApiModelProperty(value = "语言")
        private String xLangCode;

        @ApiModelProperty(value = "系统环境语言")
        private String xSystemLangCode;

        @ApiModelProperty(value = "调用方app id")
        private String xAppId;

        @ApiModelProperty(value = "初始来源调用方app id")
        private String xSourceAppId;

        @ApiModelProperty(value = "客户端IP")
        private String xClientIp;

        @ApiModelProperty(value = "开放ID")
        private String xOpenId;

        @ApiModelProperty(value = "开放平台")
        private Integer xOpenPlatform;

        @ApiModelProperty(value = "设备ID")
        private String xDeviceId;

        @ApiModelProperty(value = "xToken")
        private String xToken;

        @ApiModelProperty(value = "xIsTest")
        private Boolean xIsTest;

        @ApiModelProperty(value = "xTestFlag")
        private String xTestFlag;

        @ApiModelProperty(value = "调用链")
        private String xTraceId;

        @ApiModelProperty(value = "调用方请求ID")
        private String xCallerId;

        @ApiModelProperty(value = "Js指纹")
        private String xJsFinger;

        @ApiModelProperty(value = "登录的Seesion")
        private String xSession;

        @ApiModelProperty(value = "app推送token")
        private String xPushToken;

        @ApiModelProperty(value = "调用Java接口连接超时时间")
        private Integer xConnectTimeoutMillis = 0;

        @ApiModelProperty(value = "调用Java接口请求超时时间")
        private Integer xReadTimeoutMillis = 0;

        @ApiModelProperty(value = "cat context")
        private YqnCatContext yqnCatContext;

        public Header() {
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public Boolean getViewAll() {
            return viewAll;
        }

        public void setViewAll(Boolean viewAll) {
            this.viewAll = viewAll;
        }

        public Long getxUserId() {
            return xUserId;
        }

        public void setxUserId(Long xUserId) {
            this.xUserId = xUserId;
        }

        public String getxUserName() {
            return xUserName;
        }

        public void setxUserName(String xUserName) {
            this.xUserName = xUserName;
        }

        public String getxBPId() {
            return xBPId;
        }

        public void setxBPId(String xBPId) {
            this.xBPId = xBPId;
        }

        public String getxLangCode() {
            return xLangCode;
        }

        public void setxLangCode(String xLangCode) {
            this.xLangCode = xLangCode;
        }

        public String getxSystemLangCode() {
            return xSystemLangCode;
        }

        public void setxSystemLangCode(String xSystemLangCode) {
            this.xSystemLangCode = xSystemLangCode;
        }

        public String getxAppId() {
            return xAppId;
        }

        public void setxAppId(String xAppId) {
            this.xAppId = xAppId;
        }

        public String getxSourceAppId() {
            return xSourceAppId;
        }

        public void setxSourceAppId(String xSourceAppId) {
            this.xSourceAppId = xSourceAppId;
        }

        public String getxClientIp() {
            return xClientIp;
        }

        public void setxClientIp(String xClientIp) {
            this.xClientIp = xClientIp;
        }

        public String getxOpenId() {
            return xOpenId;
        }

        public void setxOpenId(String xOpenId) {
            this.xOpenId = xOpenId;
        }

        public Integer getxOpenPlatform() {
            return xOpenPlatform;
        }

        public void setxOpenPlatform(Integer xOpenPlatform) {
            this.xOpenPlatform = xOpenPlatform;
        }

        public String getxDeviceId() {
            return xDeviceId;
        }

        public void setxDeviceId(String xDeviceId) {
            this.xDeviceId = xDeviceId;
        }

        public String getxToken() {
            return xToken;
        }

        public void setxToken(String xToken) {
            this.xToken = xToken;
        }

        public Boolean getxIsTest() {
            return xIsTest;
        }

        public void setxIsTest(Boolean xIsTest) {
            this.xIsTest = xIsTest;
        }

        public String getxTestFlag() {
            return xTestFlag;
        }

        public void setxTestFlag(String xTestFlag) {
            this.xTestFlag = xTestFlag;
        }

        public String getxTraceId() {
            return xTraceId;
        }

        public void setxTraceId(String xTraceId) {
            this.xTraceId = xTraceId;
        }

        public String getxCallerId() {
            return xCallerId;
        }

        public void setxCallerId(String xCallerId) {
            this.xCallerId = xCallerId;
        }

        public String getxJsFinger() {
            return xJsFinger;
        }

        public void setxJsFinger(String xJsFinger) {
            this.xJsFinger = xJsFinger;
        }

        public String getxSession() {
            return xSession;
        }

        public void setxSession(String xSession) {
            this.xSession = xSession;
        }

        public String getxPushToken() {
            return xPushToken;
        }

        public void setxPushToken(String xPushToken) {
            this.xPushToken = xPushToken;
        }

        public Integer getxConnectTimeoutMillis() {
            return xConnectTimeoutMillis;
        }

        public void setxConnectTimeoutMillis(Integer xConnectTimeoutMillis) {
            this.xConnectTimeoutMillis = xConnectTimeoutMillis;
        }

        public Integer getxReadTimeoutMillis() {
            return xReadTimeoutMillis;
        }

        public void setxReadTimeoutMillis(Integer xReadTimeoutMillis) {
            this.xReadTimeoutMillis = xReadTimeoutMillis;
        }

        public YqnCatContext getYqnCatContext() {
            return yqnCatContext;
        }

        public void setYqnCatContext(YqnCatContext yqnCatContext) {
            this.yqnCatContext = yqnCatContext;
        }
    }
}