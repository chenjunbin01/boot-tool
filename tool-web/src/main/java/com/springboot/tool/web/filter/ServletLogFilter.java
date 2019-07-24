package com.springboot.tool.web.filter;


import com.springboot.tool.common.consts.TraceConst;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author chenjunbin
 * @Date 2019/7/9
 * @Description
 */
public class ServletLogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        http接口可通过header中设置信息来传递traceId
//        String traceId = request.getHeader(TraceConst.TRACE_ID);
//        if (traceId == null || "".equals(traceId)) {
//            traceId = UUID.randomUUID().toString().replaceAll("-", "");
//        }
//        MDC.put(TraceConst.TRACE_ID, traceId);
        filterChain.doFilter(servletRequest,servletResponse);
//        MDC.clear();

    }

}
