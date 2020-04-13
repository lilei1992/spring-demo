package com.fss.springdemo.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/13 20:25
 **/
@ApiModel(value = "Result", description = "Result")
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1905775611728626568L;
    protected static final int ERROR_CODE = 500;
    protected static final int SUCCESS_CODE = 200;

    @ApiModelProperty(value = "成功标识")
    protected boolean success = true;

    @ApiModelProperty(value = "响应体header对象")
    protected ResponseHeader header;

    @ApiModelProperty(value = "业务对象")
    protected T data;

    @ApiModelProperty(value = "业务运行msg code")
    protected String msgCode;

    @ApiModelProperty(value = "业务结果code")
    protected int code = SUCCESS_CODE;

    @ApiModelProperty(value = "业务运行msg")
    protected String msg;

    @ApiModelProperty(value = "业务运行msg detail")
    protected String msgDetail;

    protected Map<String, String> headers = new HashMap();
    protected Map bizExtMap;

    public Map getBizExtMap() {
        return this.bizExtMap;
    }

    public void setBizExtMap(Map bizExtMap) {
        this.bizExtMap = bizExtMap;
    }

    public void set302Jump(String url) {
        this.code = 302;
        this.headers.put("Location", url);
    }

    public void setCacheControl(int maxAge, Date lastModified, String cacheKey) {
        this.headers.put("Cache-Control", "max-age=" + maxAge);
        this.setLastModified(lastModified);
        this.setCacheKey(cacheKey);
    }

    public void setCachedCode() {
        this.code = 304;
    }

    public void setLimitCode() {
        this.code = 420;
    }

    public void setCacheKey(String cacheKey) {
        if (cacheKey != null) {
            this.headers.put("CacheKey", cacheKey);
        }

    }

    public void setLastModified(Date lastModified) {
        Date d = null;
        if (lastModified != null) {
            d = lastModified;
        } else {
            d = new Date();
        }

        this.headers.put("Last-Modified", DateUtil.getGmtTime(d));
    }

    public void setCacheControl(String cacheControl, Date lastModified, String cacheKey) {
        this.headers.put("Cache-Control", cacheControl);
        this.setLastModified(lastModified);
        this.setCacheKey(cacheKey);
    }

    public void isCached(boolean isCached) {
        this.headers.put("isCached", String.valueOf(isCached));
    }

    public void isCached(boolean isCached, int mtopCachedMaxAge) {
        this.headers.put("isCached", String.valueOf(isCached));
        this.headers.put("mtopCachedMaxAge", String.valueOf(mtopCachedMaxAge));
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void addHeader(String key, String value) {
        this.headers.put(key, value);
    }

    /**
     * @deprecated
     */
    @Deprecated
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(boolean success, String msgCode, String msg) {
        this.success = success;
        this.msgCode = msgCode;
        this.msg = msg;
    }

    public Result(boolean success, String msgCode, String msg, T data) {
        this.success = success;
        this.msgCode = msgCode;
        this.msg = msg;
        this.data = data;
    }

    public Result() {
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsgCode() {
        return this.msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ResponseHeader getHeader() {
        return header;
    }

    public void setHeader(ResponseHeader header) {
        this.header = header;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static int getErrorCode() {
        return ERROR_CODE;
    }

    public static int getSuccessCode() {
        return SUCCESS_CODE;
    }

    public String getMsgDetail() {
        return msgDetail;
    }

    public void setMsgDetail(String msgDetail) {
        this.msgDetail = msgDetail;
    }
}