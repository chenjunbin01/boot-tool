package com.springboot.tool.web.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

/**
 * @Author chenjunbin
 * @Date 2019/5/27
 * @Description
 */
public class ApplicationContextUtil implements ApplicationContextAware {
    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }


    public static <T> T getBean(String beanName) {
        if (StringUtils.isEmpty(beanName) || context == null) {
            return null;
        }
        return (T) context.getBean(beanName);
    }

    public static ApplicationContext getContext() {
        return context;
    }

}
