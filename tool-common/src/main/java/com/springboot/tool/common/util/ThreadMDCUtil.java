package com.springboot.tool.common.util;

import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @Author chenjunbin
 * @Date 2019/8/1
 * @Description
 */
public class ThreadMDCUtil {

    public static final String TRACE_ID = "traceId";


    public static void init() {
        if (MDC.get(TRACE_ID) == null) MDC.put(TRACE_ID, getUUID());
    }

    public static void clean() {
        MDC.clear();
    }

    public static String getTraceId() {
        return MDC.get(TRACE_ID);
    }

    public static void setTraceId(String traceId) {
        MDC.put(TRACE_ID, traceId);
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


}
