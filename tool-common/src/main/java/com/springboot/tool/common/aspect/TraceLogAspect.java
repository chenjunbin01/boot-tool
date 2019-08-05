package com.springboot.tool.common.aspect;

import com.alibaba.druid.util.StringUtils;
import com.springboot.tool.common.util.ThreadMDCUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Author chenjunbin
 * @Date 2019/7/9
 * @Description
 */
@Aspect
@Component
public class TraceLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(TraceLogAspect.class);

    /**
     * 定义切点Pointcut
     * 第一个*号：表示返回类型， *号表示所有的类型
     * 第二个*号：表示类名，*号表示所有的类
     * 第三个*号：表示方法名，*号表示所有的方法
     * 后面括弧里面表示方法的参数，两个句点表示任何参数
     */
    @Pointcut("execution(* com.springboot.tool.web.controller..*.*(..))")
    public void executionService() {
    }

//    @Around(value = "executionService()")
//    public Object around(ProceedingJoinPoint pjp) throws Throwable {
//        return pjp.proceed();
//    }

    @Before(value = "executionService()")
    public void before(JoinPoint jp) {
        logger.info("test");
        ThreadMDCUtil.init();
    }

    @AfterReturning(pointcut = "executionService()")
    public void after() {
        logger.info("clear MDC");
        ThreadMDCUtil.clean();
    }

}
