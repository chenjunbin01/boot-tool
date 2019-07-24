package com.springboot.tool.core.manager;

import com.springboot.tool.core.config.SqlPrintInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author chenjunbin
 * @Date 2019/6/12
 * @Description
 */
@Component
public class HealthManager {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String checkHealth() {
        logger.error("hahahaha");
        return "ok";
    }


}
