package com.springboot.tool.core.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * @Author chenjunbin
 * @Date 2019/6/18
 * @Description
 */
@Component
public class TestSchedule {
    private static final Logger logger = LoggerFactory.getLogger(TestSchedule.class);


    @Scheduled(fixedRate = 1000 * 30)
    public void reportCurrentTime() {
        logger.info("Scheduling Tasks is running");
    }

}
