package com.fss.springdemo.util;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/13 20:26
 **/
public class ApplicationException extends RuntimeException {
    /**
     * result code
     */
    protected CodeEnum codeEnum;

    protected String codeStr;

    protected Integer bizCode;

    public ApplicationException(String msg) {
        super(msg);
        codeEnum = CodeEnum.APPLICATION_ERROR;
    }

    public ApplicationException(String msg, CodeEnum code) {
        super(msg);
        this.codeEnum = code;

    }

    public ApplicationException(String msg, String code) {
        super(msg);
        this.codeStr = code;
    }

    public ApplicationException(String msg, Integer bizCode) {
        super(msg);
        this.codeEnum = CodeEnum.APPLICATION_ERROR;
        this.bizCode = bizCode;
    }

    public CodeEnum getCodeEnum() {
        return codeEnum;
    }

    public String getCodeStr() {
        return codeStr;
    }

    public Integer getBizCode() {
        return bizCode;
    }
}
