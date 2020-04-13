package com.fss.springdemo.util;

import io.swagger.annotations.ApiModel;

/**
 * @author lilei
 * @version 1.0
 * @since 2020/4/13 20:25
 **/
@ApiModel(value = "Response", description = "Response")
public class Response<T> extends Result<T> {

    /**
     * 正确输出, 不带数据
     */
    public static <T> Response<T> successResponse() {
        Response<T> response = new Response<T>();
        response.setSuccess(true);
        response.setMsgCode(CodeEnum.SUCCESS.toString());
        response.setData(null);
        return response;
    }

    /**
     * 正确输出
     *
     * @param data
     */
    public static <T> Response<T> successResponse(T data) {
        Response<T> response = new Response<T>();
        response.setSuccess(true);
        response.setMsgCode(CodeEnum.SUCCESS.toString());
        response.setData(data);
        return response;
    }

    /**
     * 正确输出, 带code
     *
     * @param code
     */
    public static <T> Response<T> successResponse(int code) {
        Response<T> response = new Response<T>();
        response.setSuccess(true);
        response.setMsgCode(CodeEnum.SUCCESS.toString());
        response.setData(null);
        response.setCode(code);
        return response;
    }

    /**
     * 正确输出, 带msg
     *
     * @param msg
     */
    public static <T> Response<T> successResponse(String msg) {
        Response<T> response = new Response<T>();
        response.setSuccess(true);
        response.setMsgCode(CodeEnum.SUCCESS.toString());
        response.setData(null);
        response.setMsg(msg);
        return response;
    }

    /**
     * 正确输出, 带data&code
     *
     * @param data
     * @param code
     */
    public static <T> Response<T> successResponse(T data, int code) {
        Response<T> response = new Response<T>();
        response.setSuccess(true);
        response.setMsgCode(CodeEnum.SUCCESS.toString());
        response.setData(data);
        response.setCode(code);
        return response;
    }

    /**
     * 正确输出, 带data&msg
     *
     * @param data
     * @param msg
     */
    public static <T> Response<T> successResponse(T data, String msg) {
        Response<T> response = new Response<T>();
        response.setSuccess(true);
        response.setMsgCode(CodeEnum.SUCCESS.toString());
        response.setData(data);
        response.setMsg(msg);
        return response;
    }

    /**
     * 正确输出, 带code&msg
     *
     * @param code
     * @param msg
     */
    public static <T> Response<T> successResponse(int code, String msg) {
        Response<T> response = new Response<T>();
        response.setSuccess(true);
        response.setMsgCode(CodeEnum.SUCCESS.toString());
        response.setData(null);
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    /**
     * 正确输出, 带code&msg
     *
     * @param code
     * @param msg
     */
    public static <T> Response<T> successResponse(T data, int code, String msg) {
        Response<T> response = new Response<T>();
        response.setSuccess(true);
        response.setMsgCode(CodeEnum.SUCCESS.toString());
        response.setData(data);
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }



    /**
     * 输出应用错误信息
     *
     * @param e
     * @param <T>
     * @return
     */
    public static <T> Response<T> errorResponse(ApplicationException e) {
        Response<T> response = new Response<T>();
        response.setSuccess(false);

        CodeEnum codeEnum = e.getCodeEnum();

        response.setMsgCode(null != codeEnum ? codeEnum.getCode() : e.getCodeStr());
        response.setMsg(e.getMessage());
        response.setData(null);
        response.setCode(ERROR_CODE);
        return response;
    }

    /**
     * 输出应用错误信息
     *
     * @param msg
     * @return
     */
    public static <T> Response<T> errorResponse(String msg) {
        Response<T> response = new Response<T>();
        response.setSuccess(false);
        response.setMsgCode(CodeEnum.APPLICATION_ERROR.getCode());
        response.setMsg(msg);
        response.setData(null);
        response.setCode(ERROR_CODE);
        return response;
    }

    /**
     * 输出应用错误信息
     *
     * @param msg
     * @return
     */
    public static <T> Response<T> errorResponse(String errorCode, String msg) {
        Response<T> response = new Response<T>();
        response.setSuccess(false);
        response.setMsgCode(errorCode);
        response.setMsg(msg);
        response.setData(null);
        response.setCode(ERROR_CODE);
        return response;
    }

    /**
     * 输出应用错误信息
     *
     * @param msg
     * @param code
     * @return
     */
    public static <T> Response<T> errorResponse(String msg, int code) {
        Response<T> response = new Response<T>();
        response.setSuccess(false);
        response.setMsg(msg);
        response.setData(null);
        response.setCode(code);
        return response;
    }

    /**
     * 输出应用错误信息
     *
     * @param msg
     * @return
     */
    public static <T> Response<T> errorResponse(String errorCode, String msg, int code) {
        Response<T> response = new Response<T>();
        response.setSuccess(false);
        response.setMsgCode(errorCode);
        response.setMsg(msg);
        response.setData(null);
        response.setCode(code);
        return response;
    }

    /**
     * 输出应用错误信息, 带返回数据
     *
     * @param msg
     * @return
     */
    public static <T> Response<T> errorResponse(T data, String errorCode, String msg) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setMsgCode(errorCode);
        response.setMsg(msg);
        response.setData(data);
        response.setCode(ERROR_CODE);
        return response;
    }

    /**
     * 输出应用错误信息, 带返回数据
     *
     * @param msg
     * @return
     */
    public static <T> Response<T> errorResponse(T data, String msg, int code) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setMsg(msg);
        response.setData(data);
        response.setCode(code);
        return response;
    }

    /**
     * 输出应用错误信息, 带返回数据
     *
     * @param msg
     * @return
     */
    public static <T> Response<T> errorResponse(T data, String errorCode, String msg, int code) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setMsgCode(errorCode);
        response.setMsg(msg);
        response.setData(data);
        response.setCode(ERROR_CODE);
        return response;
    }

    /**
     * 输出应用信息
     *
     * @param codeEnum
     * @return
     */
    public static <T> Response<T> errorResponse(CodeEnum codeEnum) {
        Response<T> response = new Response<T>();
        response.setSuccess(false);
        response.setMsgCode(codeEnum.getCode());
        response.setMsg(codeEnum.getMsg());
        response.setData(null);
        response.setCode(ERROR_CODE);
        return response;
    }

    public static <T> Response<T> errorAntiBrushResponse() {
        Response<T> response = new Response<T>();
        response.setSuccess(false);
        response.setMsgCode(CodeEnum.ANTI_BRUSH.getCode());
        response.setMsg(CodeEnum.ANTI_BRUSH.getMsg());
        response.setData(null);
        response.setCode(ERROR_CODE);
        return response;
    }


    private Response() {
        super();
    }


    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", header=" + header +
                ", data=" + data +
                ", msgCode=" + msgCode  +
                ", code=" + code +
                ", msg=" + msg +
                ", headers=" + headers +
                ", bizExtMap=" + bizExtMap +
                '}';
    }

}
