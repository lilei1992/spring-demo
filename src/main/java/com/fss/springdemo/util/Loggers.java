package com.fss.springdemo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fss.springdemo.config.AppConstantsConfig;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

/**
 * @author yueqi.syq
 * @date 2018/08/23 15:00
 */
@SuppressWarnings("unused")
public class Loggers {
    private static final String DELIMITER = "·";
    private static final String REPLACED_DELIMITER = "^@#";
    private static final String SERVER_IP = IPUtils.getServerIP();
    public static boolean writeToConsole=false;

    // Interface
    public static class INTERFACE {
        public static void trace(String interfaceName
                , String role
                , String rt
                , String result
                , String interfaceUrl
                , Object req
                , Object resp
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(interfaceName, role, rt, result, interfaceUrl, req, resp, exp);
            LogUtils.trace("INTERFACE", paramsMap);
        }

        public static void debug(String interfaceName
                , String role
                , String rt
                , String result
                , String interfaceUrl
                , Object req
                , Object resp
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(interfaceName, role, rt, result, interfaceUrl, req, resp, exp);
            LogUtils.debug("INTERFACE", paramsMap);
        }

        /**
         * 接口Interface info日志
         *
         * @param interfaceName 接口名
         * @param role          请求角色 provider 或者 consumer | 这里只会是consumer
         * @param rt            时间(单位：毫秒)
         * @param result        结果（error 或者 success）
         * @param req           请求报文
         * @param resp          响应报文
         * @param exp           异常对象
         */
        public static void info(String interfaceName
                , String role
                , String rt
                , String result
                , String interfaceUrl
                , Object req
                , Object resp
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(interfaceName, role, rt, result, interfaceUrl, req, resp, exp);
            LogUtils.info("INTERFACE", paramsMap);
        }

        public static void info(String interfaceName
                , String role
                , String rt
                , String result
                , Object req
                , Object resp
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(interfaceName, role, rt, result, "", req, resp, exp);
            LogUtils.info("INTERFACE", paramsMap);
        }

        public static void warn(String interfaceName
                , String role
                , String rt
                , String result
                , String interfaceUrl
                , Object req
                , Object resp
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(interfaceName, role, rt, result, interfaceUrl, req, resp, exp);
            LogUtils.warn("INTERFACE", paramsMap);
        }

        public static void error(String interfaceName
                , String role
                , String rt
                , String result
                , String interfaceUrl
                , Object req
                , Object resp
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(interfaceName, role, rt, result, interfaceUrl, req, resp, exp);
            LogUtils.error("INTERFACE", paramsMap);
        }

        public static void error(String interfaceName
                , String role
                , String rt
                , String result
                , Object req
                , Object resp
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(interfaceName, role, rt, result, "", req, resp, exp);
            LogUtils.error("INTERFACE", paramsMap);
        }

        /**
         * 构建paramsMap
         * @param interfaceName 接口名
         * @param role          请求角色 provider 或者 consumer | 这里只会是consumer
         * @param rt            时间(单位：毫秒)
         * @param result        结果（error 或者 success）
         * @param req           请求报文
         * @param resp          响应报文
         * @param exp           异常对象
         * @return
         */
        private static Map<String, Object> buildParamsMap(String interfaceName
                , String role
                , String rt
                , String result
                , String interfaceUrl
                , Object req
                , Object resp
                , Throwable exp) {
            Map<String, Object> paramsMap = new HashMap<>();
            paramsMap.put("interface_name", interfaceName);
            paramsMap.put("role", role);
            paramsMap.put("rt", LogUtils.getRt(rt));
            paramsMap.put("result", result);
            paramsMap.put("interface_url", interfaceUrl);
            paramsMap.put("interface_req", LogUtils.getParamObj(req));
            paramsMap.put("interface_resp", LogUtils.getParamObj(resp));
            paramsMap.put("exp", LogUtils.getStackTrace(exp));

            return paramsMap;
        }
    }

    // Interface
    public static class FRONT {

        /**
         * 前端日志
         *
         * @param logType 日志类型，前端自定义，随意扩展
         * @param logContent 日志详情，JsonObject
         */
        public static void info(String logType
                , JSONObject logContent) {
            Map<String, Object> paramsMap = FRONT.buildParamsMap(logType, logContent);
            LogUtils.info("FRONT", paramsMap);
        }

        /**
         * 前端日志
         *
         * @param logType 日志类型，前端自定义，随意扩展
         * @param logContent 日志详情，JsonObject
         */
        public static void warn(String logType
                , JSONObject logContent) {
            Map<String, Object> paramsMap = FRONT.buildParamsMap(logType, logContent);
            LogUtils.warn("FRONT", paramsMap);
        }
        /**
         * 前端日志
         *
         * @param logType 日志类型，前端自定义，随意扩展
         * @param logContent 日志详情，JsonObject
         */
        public static void error(String logType
                , JSONObject logContent) {
            Map<String, Object> paramsMap = FRONT.buildParamsMap(logType, logContent);
            LogUtils.error("FRONT", paramsMap);
        }
        /**
         * 构建paramsMap
         * @param logType 日志类型，前端自定义，随意扩展
         * @param content 日志详情，JsonObject
         * @return
         */
        private static Map<String, Object> buildParamsMap(String logType
                , JSONObject content) {
            Map<String, Object> paramsMap = new HashMap<>(3);
            paramsMap.put("log_type", "FRONT");
            paramsMap.put("front_type", logType);
            paramsMap.put(logType+"_log_content", content);

            return paramsMap;
        }
    }
    // DB
    public static class DB {
        public static void log(String sqlId, long rt, String sql) {
            Map<String, Object> paramsMap = buildParamsMap(sqlId, sql, String.valueOf(rt), null);
            LogUtils.info("DB", paramsMap);
        }

        public static void log(String sqlId
                , long rt
                , String sql
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(sqlId, sql, String.valueOf(rt), exp);
            LogUtils.info("DB", paramsMap);
        }

        public static void trace(String sql
                , String rt
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(null, sql, rt, exp);
            LogUtils.trace("DB", paramsMap);
        }

        public static void debug(String sql
                , String rt
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(null, sql, rt, exp);
            LogUtils.debug("DB", paramsMap);
        }

        /**
         * 数据库DB info日志
         * @param sql           sql语句
         * @param rt            时间(单位：毫秒)
         */
        public static void info(String sql
                , String rt) {
            Map<String, Object> paramsMap = buildParamsMap(null, sql, rt, null);
            LogUtils.info("DB", paramsMap);
        }

        public static void info(String sql
                , String rt
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(null, sql, rt, exp);
            LogUtils.info("DB", paramsMap);
        }

        public static void warn(String sql
                , String rt
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(null, sql, rt, exp);
            LogUtils.warn("DB", paramsMap);
        }

        public static void error(String sql
                , String rt
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(null, sql, rt, exp);
            LogUtils.error("DB", paramsMap);
        }

        /**
         * 构建paramsMap
         * @param sqlId         sql接口&方法名
         * @param sql           接口名
         * @param rt            时间(单位：毫秒)
         * @param exp           异常对象
         * @return
         */
        private static Map<String, Object> buildParamsMap(String sqlId
                , String sql
                , String rt
                , Throwable exp) {
            Map<String, Object> paramsMap = new HashMap<>(4);

            if (sqlId != null) {
                paramsMap.put("sql_id", sqlId);
            }
            paramsMap.put("sql", sql);
            paramsMap.put("exp", LogUtils.getStackTrace(exp));
            paramsMap.put("rt", LogUtils.getRt(rt));

            return paramsMap;
        }
    }


    // MQ
    public static class MQ {
        public static void trace(String role
                , String exchange
                , String queue
                , Object message
                , String rt
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(role, exchange, queue, message, rt, exp);
            LogUtils.trace("MQ", paramsMap);
        }

        public static void debug(String role
                , String exchange
                , String queue
                , Object message
                , String rt
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(role, exchange, queue, message, rt, exp);
            LogUtils.debug("MQ", paramsMap);
        }

        /**
         * MQ info 日志
         * @param role          请求角色 provider 或者 consumer
         * @param exchange      exchange名
         * @param queue         queue名
         * @param message       message内容
         * @param rt            时间(单位：毫秒)
         * @return
         */
        public static void info(String role
                , String exchange
                , String queue
                , Object message
                , String rt) {
            Map<String, Object> paramsMap = buildParamsMap(role, exchange, queue, message, rt, null);
            LogUtils.info("MQ", paramsMap);
        }

        public static void info(String role
                , String exchange
                , String queue
                , Object message
                , String rt
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(role, exchange, queue, message, rt, exp);
            LogUtils.info("MQ", paramsMap);
        }

        public static void warn(String role
                , String exchange
                , String queue
                , Object message
                , String rt
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(role, exchange, queue, message, rt, exp);
            LogUtils.warn("MQ", paramsMap);
        }

        public static void error(String role
                , String exchange
                , String queue
                , Object message
                , String rt
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(role, exchange, queue, message, rt, exp);
            LogUtils.error("MQ", paramsMap);
        }

        /**
         * 构建paramsMap
         * @param role          请求角色 provider 或者 consumer
         * @param exchange      exchange名
         * @param queue         queue名
         * @param message       message内容
         * @param rt            时间(单位：毫秒)
         * @param exp           异常对象
         * @return
         */
        private static Map<String, Object> buildParamsMap(String role
                , String exchange
                , String queue
                , Object message
                , String rt
                , Throwable exp) {
            Map<String, Object> paramsMap = new HashMap<>(6);

            paramsMap.put("role", role);
            paramsMap.put("mq_exchange", exchange);
            paramsMap.put("mq_queue", queue);
            paramsMap.put("rt", LogUtils.getRt(rt));
            paramsMap.put("mq_message", LogUtils.getParamObj(message));
            paramsMap.put("exp", LogUtils.getStackTrace(exp));

            return paramsMap;
        }
    }


    // Cache
    public static class CACHE {

        public static void trace(String accessIp
                , Object key
                , Object value
                , String rt
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(accessIp, key, value, rt, exp);
            LogUtils.trace("CACHE", paramsMap);
        }

        public static void debug(String accessIp
                , Object key
                , Object value
                , String rt
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(accessIp, key, value, rt, exp);
            LogUtils.debug("CACHE", paramsMap);
        }

        /**
         * 缓存CACHE info日志
         *
         * @param accessIp 使用IP
         * @param key      缓存key
         * @param value    缓存value
         * @param rt       时间(单位：毫秒)
         */
        public static void info(String accessIp
                , Object key
                , Object value
                , String rt) {
            Map<String, Object> paramsMap = buildParamsMap(accessIp, key, value, rt, null);
            LogUtils.info("CACHE", paramsMap);
        }

        public static void info(String accessIp
                , Object key
                , Object value
                , String rt
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(accessIp, key, value, rt, exp);
            LogUtils.info("CACHE", paramsMap);
        }

        public static void warn(String accessIp
                , Object key
                , Object value
                , String rt
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(accessIp, key, value, rt, exp);
            LogUtils.warn("CACHE", paramsMap);
        }

        public static void error(String accessIp
                , Object key
                , Object value
                , String rt
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(accessIp, key, value, rt, exp);
            LogUtils.error("CACHE", paramsMap);
        }


        /**
         * 构建paramsMap
         * @param accessIp      连接地址
         * @param key           缓存key
         * @param value         缓存value
         * @param rt            时间(单位：毫秒)
         * @param exp           异常对象
         * @return
         */
        private static Map<String, Object> buildParamsMap(String accessIp
                , Object key
                , Object value
                , String rt
                , Throwable exp) {
            Map<String, Object> paramsMap = new HashMap<>(5);

            paramsMap.put("access_ip", accessIp);
            paramsMap.put("rt", LogUtils.getRt(rt));
            paramsMap.put("cache_key", LogUtils.getParamJson(key));
            paramsMap.put("cache_value", LogUtils.getParamJson(value));
            paramsMap.put("exp", LogUtils.getStackTrace(exp));

            return paramsMap;
        }
    }


    // 业务 BIZ
    public static class BIZ {

        public static void trace(String className
                , String methodName
                , Object message
                , Object body
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(className, methodName, message, body, exp);
            LogUtils.trace("BIZ", paramsMap);
        }

        public static void trace(Map<String, String> params
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(params, exp);
            LogUtils.trace("BIZ", paramsMap);
        }

        public static void trace(String logMessage
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(logMessage, exp);
            LogUtils.trace("BIZ", paramsMap);
        }


        public static void debug(String className
                , String methodName
                , Object message
                , Object body
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(className, methodName, message, body, exp);
            LogUtils.debug("BIZ", paramsMap);
        }

        public static void debug(Map<String, String> params
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(params, exp);
            LogUtils.debug("BIZ", paramsMap);
        }

        public static void debug(String logMessage
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(logMessage, exp);
            LogUtils.debug("BIZ", paramsMap);
        }


        /**
         * 业务BIZ info日志
         *
         * @param className  类名
         * @param methodName 方法名
         * @param message    message title
         * @param body       message body
         */
        public static void info(String className
                , String methodName
                , Object message
                , Object body) {
            Map<String, Object> paramsMap = buildParamsMap(className, methodName, message, body, null);
            LogUtils.info("BIZ", paramsMap);
        }

        /**
         * 业务BIZ info日志
         *
         * @param params 参数map
         */
        public static void info(Map<String, String> params) {
            Map<String, Object> paramsMap = new HashMap<>();
            paramsMap.putAll(params);
            LogUtils.info("BIZ", paramsMap);
        }

        /**
         * 业务BIZ info日志
         *
         * @param logMessage 业务描述
         */
        public static void info(String logMessage) {
            Map<String, Object> paramsMap = buildParamsMap(logMessage, null);
            LogUtils.info("BIZ", paramsMap);
        }

        public static void info(String logMessage, String titleName) {
            Map<String, Object> paramsMap = buildParamsMap(logMessage, null);
            paramsMap.put("titlename", titleName);
            LogUtils.info("BIZ", paramsMap);
        }

        public static void info(String logMessage, String titleName, Map<String, String> params) {
            Map<String, Object> paramsMap = buildParamsMap(params, null);
            paramsMap.put("titlename", titleName);
            LogUtils.info("BIZ", paramsMap);
        }


        public static void warn(String className
                , String methodName
                , Object message
                , Object body
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(className, methodName, message, body, exp);
            LogUtils.warn("BIZ", paramsMap);
        }

        public static void warn(Map<String, String> params
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(params, exp);
            LogUtils.warn("BIZ", paramsMap);
        }

        public static void warn(String logMessage
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(logMessage, exp);
            LogUtils.warn("BIZ", paramsMap);
        }


        public static void error(String className
                , String methodName
                , Object message
                , Object body
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(className, methodName, message, body, exp);
            LogUtils.error("BIZ", paramsMap);
        }

        public static void error(Map<String, String> params
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(params, exp);
            LogUtils.error("BIZ", paramsMap);
        }

        public static void error(String logMessage
                , Throwable exp) {
            Map<String, Object> paramsMap = buildParamsMap(logMessage, exp);
            LogUtils.error("BIZ", paramsMap);
        }

        /**
         * 构建paramsMap
         * @param className     类名字
         * @param methodName    方法名字
         * @param message       业务log message信息
         * @param body          业务log body信息
         * @param exp           异常对象
         * @return
         */
        private static Map<String, Object> buildParamsMap(String className
                , String methodName
                , Object message
                , Object body
                , Throwable exp) {
            Map<String, Object> paramsMap = new HashMap<>(5);
            paramsMap.put("class_name", className);
            paramsMap.put("method_name", methodName);
            paramsMap.put("biz_message", LogUtils.getParamJson(message));
            paramsMap.put("biz_body", LogUtils.getParamJson(body));
            paramsMap.put("exp", LogUtils.getStackTrace(exp));

            return paramsMap;
        }

        /**
         * 构建paramsMap
         * @param logMessage    日志内容
         * @param exp           异常对象
         * @return
         */
        private static Map<String, Object> buildParamsMap(String logMessage
                , Throwable exp) {
            Map<String, Object> paramsMap = new HashMap<>(2);
            paramsMap.put("log_message", logMessage);
            paramsMap.put("exp", LogUtils.getStackTrace(exp));

            return paramsMap;
        }

        /**
         * 构建paramsMap
         * @param params        日志内容
         * @param exp           异常对象
         * @return
         */
        private static Map<String, Object> buildParamsMap(Map<String, String> params
                , Throwable exp) {
            Map<String, Object> paramsMap = new HashMap<>(10);
            paramsMap.putAll(params);
            paramsMap.put("exp", LogUtils.getStackTrace(exp));

            return paramsMap;
        }
    }


    // 第三方服务调用
    public static class Service3RD {
        public static void trace(String url
                , String role
                , String rt
                , String result
                , Object req
                , Object resp
                , Throwable exp) {
            Map<String, Object> params = buildParamsMap(url, role, rt, result, req, resp, exp);
            LogUtils.trace("3RD_SERVICE", params);
        }

        public static void debug(String url
                , String role
                , String rt
                , String result
                , Object req
                , Object resp
                , Throwable exp) {
            Map<String, Object> params = buildParamsMap(url, role, rt, result, req, resp, exp);
            LogUtils.debug("3RD_SERVICE", params);
        }

        /**
         * 第三方调用 3RD_SERVICE info日志
         *
         * @param url           调用第三方url地址
         * @param role          请求角色 provider 或者 consumer | 这里只会是consumer
         * @param rt            时间(单位：毫秒)
         * @param result        结果（error 或者 success）
         * @param req           请求报文
         * @param resp          响应报文
         * @param exp           异常对象
         */
        public static void info(String url
                , String role
                , String rt
                , String result
                , Object req
                , Object resp
                , Throwable exp) {
            Map<String, Object> params = buildParamsMap(url, role, rt, result, req, resp, exp);
            LogUtils.info("3RD_SERVICE", params);
        }

        public static void warn(String url
                , String role
                , String rt
                , String result
                , Object req
                , Object resp
                , Throwable exp) {
            Map<String, Object> params = buildParamsMap(url, role, rt, result, req, resp, exp);
            LogUtils.warn("3RD_SERVICE", params);
        }

        public static void error(String url
                , String role
                , String rt
                , String result
                , Object req
                , Object resp
                , Throwable exp) {
            Map<String, Object> params = buildParamsMap(url, role, rt, result, req, resp, exp);
            LogUtils.error("3RD_SERVICE", params);
        }

        /**
         * 构建paramsMap
         * @param url           调用第三方url地址
         * @param role          请求角色 provider 或者 consumer | 这里只会是consumer
         * @param rt            时间(单位：毫秒)
         * @param result        结果（error 或者 success）
         * @param req           请求报文
         * @param resp          响应报文
         * @param exp           异常对象
         * @return
         */
        private static Map<String, Object> buildParamsMap(String url
                , String role
                , String rt
                , String result
                , Object req
                , Object resp
                , Throwable exp) {
            Map<String, Object> paramsMap = new HashMap<>(7);
            paramsMap.put("url", url);
            paramsMap.put("role", role);
            paramsMap.put("rt", LogUtils.getRt(rt));
            paramsMap.put("result", result);
            paramsMap.put("3rd_service_req", LogUtils.getParamJson(req));
            paramsMap.put("3rd_service_resp", LogUtils.getParamJson(resp));
            paramsMap.put("exp", LogUtils.getStackTrace(exp));

            return paramsMap;
        }

    }

    private static class LogUtils {

        public static void trace(String logName, String format, String... params) {

            log(logName, "trace", format, params);
        }

        public static void trace(String logName, Map<String, Object> paramsMap) {

            log(logName, "trace", paramsMap);
        }

        public static void debug(String logName, String format, String... params) {

            log(logName, "debug", format, params);
        }

        public static void debug(String logName, Map<String, Object> paramsMap) {

            log(logName, "debug", paramsMap);
        }

        public static void info(String logName, String format, String... params) {

            log(logName, "info", format, params);
        }

        public static void info(String logName, Map<String, Object> paramsMap) {

            log(logName, "info", paramsMap);
        }

        public static void info(String logName, Map<String, Object> paramsMap, String format, String... params) {

            log(logName, "info", paramsMap, format, params);
        }

        public static void warn(String logName, String format, String... params) {

            log(logName, "warn", format, params);
        }

        public static void warn(String logName, Map<String, Object> paramsMap) {

            log(logName, "warn", paramsMap);
        }

        public static void error(String logName, String format, String... params) {
            log(logName, "error", format, params);
        }

        public static void error(String logName, Map<String, Object> paramsMap) {
            log(logName, "error", paramsMap);
        }

        private static void log(String logName, String level, String format, String... params) {
            log(logName, level, null, format, params);
        }

        private static void log(String logName, String level, Map<String, Object> paramsMap) {
            log(logName, level, paramsMap, null);
        }


        /**
         * 汇总log内容，执行输出
         * @param logName
         * @param level
         * @param paramsMap
         * @param format
         * @param params
         */
        private static void log(String logName, String level, Map<String, Object> paramsMap, String format, String... params) {
            final Logger logger = LoggerFactory.getLogger(logName);
            if (null == logger) {
                throw new RuntimeException(String.format("No logger named %s found!", logName));
            }
            Map<String, Object> logMap = getCommonLogMap(logName, level);
            if (MapUtils.isNotEmpty(paramsMap)) {
                logMap.putAll(paramsMap);
            }
            if (StringUtils.isNotEmpty(format)) {
                logMap.put("bizmessage", String.format(format, params));
            }
            dumpLog(logger, level, logMap);

        }

        /**
         * 实际调用log底层接口
         * @param logger
         * @param level
         * @param logMap
         */
        private static void dumpLog(Logger logger, String level, Map<String, Object> logMap) {
            if (writeToConsole) {
                System.out.println(JSON.toJSONString(logMap));
            }
            switch (level) {
                case "trace": {
                    logger.trace(JSON.toJSONString(logMap));
                }
                break;
                case "debug": {
                    logger.debug(JSON.toJSONString(logMap));
                }
                break;
                case "info": {
                    logger.info(JSON.toJSONString(logMap));
                }
                break;
                case "warn": {
                    logger.warn(JSON.toJSONString(logMap));
                }
                break;
                case "error": {
                    logger.error(JSON.toJSONString(logMap));
                }
                break;
                default:
                    break;
            }
        }

        // 公共日志
        public static Map<String, Object> getCommonLogMap(String logName, String logLevel) {
            String remoteAppId = "unknownApp";
            String clientIp = "0.0.0.0";
            String traceId = "";
            String callerId = "";

            Request.Header header = RequestHeaderContext.getHeaderContext();
            if (header != null && header.getxAppId() != null) {
                remoteAppId = header.getxAppId();
            }
            if (header != null && header.getxClientIp() != null) {
                clientIp = header.getxClientIp();
            }
            if (header != null && header.getxTraceId() != null) {
                traceId = header.getxTraceId();
            }
            if (header != null && header.getxCallerId() != null) {
                callerId = header.getxCallerId();
            }

            Map<String, Object> logMap = new HashMap<>();
            // 时间
            SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            logMap.put("log_timestamp", df.format(new Date()));

            // 服务端 IP
            logMap.put("server_ip", SERVER_IP);
            // 应用的APP ID
            logMap.put("app_id", AppConstantsConfig.APP_ID);
            // 应用的APP Name
            logMap.put("app_name", AppConstantsConfig.APP_NAME);
            // 线程ID
            logMap.put("thread_id", String.valueOf(Thread.currentThread().getId()));
            // Interface，DB，MQ，Cache，Biz
            logMap.put("log_type", logName);
            // Error,Debug,Warning,Info
            logMap.put("log_level", logLevel);

            // 客户端 IP
            logMap.put("client_ip", clientIp);
            // CAT的 traceUrl
            logMap.put("trace_id", traceId);
            // 远程调用方app id
            logMap.put("remote_app_id", remoteAppId);
            // 调用请求ID
            logMap.put("caller_id", callerId);
            return logMap;
        }

        /**
         * Throwable —> String
         * @param aThrowable
         * @return
         */
        public static String getStackTrace(Throwable aThrowable) {
            if (null != aThrowable) {
                if (writeToConsole) {
                    aThrowable.printStackTrace();
                }
                final Writer result = new StringWriter();
                final PrintWriter printWriter = new PrintWriter(result);
                aThrowable.printStackTrace(printWriter);
                return processText(result.toString());
            }

            return "";
        }

        /**
         * 返回param的对象
         * @param param
         * @return
         */
        public static Object getParamObj(Object param) {
            if (param == null) {
                return "null";
            } else if (param instanceof String) {
                return param;
            } else if (param instanceof Request) {
                Request<String> request = new Request<>();
                request.setHeader(((Request)param).getHeader());
                request.setModel(JSON.toJSONString(((Request)param).getModel()));
                return request;
            } else if (param instanceof Response) {
                final Response<String> response = Response.successResponse();
                response.setSuccess(((Result)param).isSuccess());
                response.setHeader(((Result)param).getHeader());
                response.setData(JSON.toJSONString(((Result)param).getData()));
                response.setMsgCode(((Result)param).getMsgCode());
                response.setCode(((Result)param).getCode());
                response.setMsg(((Result)param).getMsg());
                Map<String,String> headers=((Result)param).getHeaders();
                headers.forEach(response::addHeader);
                response.setBizExtMap(((Result)param).getBizExtMap());

                return response;
            } else {
                return JSON.toJSONString(param);
            }
        }

        /**
         * 返回json
         * @param param
         * @return
         */
        public static Object getParamJson(Object param) {
            return JSON.toJSONString(param);
        }

        /**
         * 获取rt
         * @param rt
         * @return
         */
        public static int getRt(String rt) {
            Integer rtInt = 0;
            try {
                rtInt = Integer.parseInt(rt);
            } catch (Exception e) {
                //e.printStackTrace();
            }

            return rtInt;
        }

        /**
         * Map -> String
         * @param params
         * @return
         */
        public static String processMapParams(Map<String, String> params) {
            Set<Entry<String, String>> set = params.entrySet();
            Iterator<Entry<String, String>> it = set.iterator();
            final StringBuilder builder = new StringBuilder(2048);
            boolean isFirstEntry = true;

            while (it.hasNext()) {
                if (isFirstEntry) {
                    isFirstEntry = false;
                } else {
                    builder.append(",");
                }

                Entry<String, String> entry = it.next();
                builder.append(LogUtils.processText(entry.getKey()))
                        .append(":")
                        .append(LogUtils.processText(entry.getValue()));
            }

            return builder.toString();
        }

        /**
         * 对String做处理，替换换行符等
         * @param text
         * @return
         */
        private static String processText(String text) {
            if (StringUtils.isBlank(text)) {
                return "";
            }

            return text.replaceAll("\\n|\\r|\\|", REPLACED_DELIMITER);
        }


    }

}