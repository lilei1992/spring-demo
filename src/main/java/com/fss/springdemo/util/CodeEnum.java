package com.fss.springdemo.util;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/13 20:26
 **/
public enum CodeEnum {

    /**
     * 含义: 调用成功
     * 客户端处理: 无
     */
    SUCCESS("SUCCESS", "调用成功"),

    /**
     * 含义: 系统错误, 通常是代码运行出现异常
     * 客户端处理: 客户端不处理，记录日志处理
     */
    SYSTEM_ERROR("FAIL_BIZ_GLOBAL_SYSTEM_ERROR", "系统错误"),

    /**
     * 含义: 应用错误, 通常是由程序自己抛出的
     * 客户端处理: 弹窗显示msg，之后需要接入错误提示系统
     */
    APPLICATION_ERROR("FAIL_BIZ_GLOBAL_APPLICATION_ERROR", "应用错误"),

    /**
     * 含义: 第三方调用错误, 通常由程序自己跑出的
     *
     */
    RPC_ERROR("FAIL_BIZ_GLOBAL_RPC_ERROR", "第三方调用错误"),

    /**
     * 含义: 网络超时异常
     */
    TIME_OUT_ERROR("FAIL_BIZ_GLOBAL_TIME_OUT_ERROR", "网络超时"),

    /**
     * 含义: 请求过于频繁，限制访问
     */
    FLOW_LIMITING("BLOCKED_BY_FLOW_LIMITING", "请求过于频繁，限制访问"),

    /**
     * 含义: 应用错误, 可控制客户端行为
     * 客户端处理: 参考http://docs.alibaba-inc.com/pages/viewpage.action?pageId=419465039
     */
    APP_ACTION_ERROR("FAIL_BIZ_GLOBAL_APP_ACTION_ERROR", "应用错误, 可控制客户端行为"),

    /**
     * 含义: 输入参数解析错误, 传入的参数无法正确的被解析
     * 客户端处理: 客户端不处理，记录日志处理
     */
    WRONG_PARAMS("FAIL_BIZ_GLOBAL_WRONG_PARAMS", "参数解析错误"),

    /**
     * 状态码: 22000
     * 含义: 调用别人的HSF错误记录
     * 客户端处理: 客户端不处理，记录日志处理
     */
    INTERFACE_ERROR("FAIL_BIZ_GLOBAL_INTERFACE_ERROR", "接口调用错误"),

    /**
     * 含义: 未登录
     * 客户端处理: 跳转登录页面
     */
    NEED_LOGIN("FAIL_BIZ_GLOBAL_NEED_LOGIN", "未登录"),

    /**
     * 含义: 请求参数组装错误
     * 客户端处理: 记录日志
     */
    INVALID_PARAMS("FAIL_BIZ_GLOBAL_INVALID_PARAMS", "参数异常"),

    /**
     * 含义: 请求资源不存在
     * 客户端处理: 不处理
     */
    NOT_FOUND("FAIL_BIZ_GLOBAL_NOT_FOUND", "资源不存在"),

    ANTI_BRUSH("FAIL_BIZ_GLOBAL_ANTI_BRUSH", "哎呀呀,慢一点"),;

    private String msg;

    private String code;

    CodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }
}
