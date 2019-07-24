package com.springboot.tool.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author chenjunbin
 * @Date 2019/7/9
 * @Description
 */
@Slf4j
@RestController
public class DynamicLoggerController {
    @Autowired
    private LoggingSystem loggingSystem;

    @RequestMapping("/updateLoggerLevel")
    public String cache(@RequestParam("loggerName") String loggerName,
                        @RequestParam("level") String level) {
        LogLevel logLevel = LogLevel.valueOf(level.toUpperCase());
        loggingSystem.setLogLevel(loggerName, logLevel);
        return "ok";
    }
}
