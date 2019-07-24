package com.springboot.tool.web.controller;

import com.springboot.tool.common.consts.TraceConst;
import com.springboot.tool.core.manager.CacheManager;
import com.springboot.tool.core.manager.HealthManager;
import com.springboot.tool.core.mapper.AcitivityMapper;
import com.springboot.tool.core.model.dataobj.ActivityDO;
import com.springboot.tool.core.model.enums.ActivityStatusEnum;
import com.springboot.tool.core.model.enums.ActivityTypeEnum;
import com.springboot.tool.web.model.TestModel;
import com.springboot.tool.web.util.ApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author chenjunbin
 * @Date 2019/5/17
 * @Description
 */
@Slf4j
@RestController
public class HealthController {

    @Autowired
    private TestModel test;
    @Autowired
    private AcitivityMapper acitivityMapper;
    @Autowired
    private HealthManager healthManager;
    @Autowired
    private CacheManager cacheManager;

    @RequestMapping("/health")
    public String health() {
        Long id = 20L;
        log.warn("haha11");
        log.error("haha111");

        Thread thread = new Thread(new Runnable() {
            Map<String, String> context = MDC.getCopyOfContextMap();
            @Override
            public void run() {
                log.info("haha2");
            }

        });
        thread.start();

        CompletableFuture.runAsync(new Runnable() {
            Map<String, String> context = MDC.getCopyOfContextMap();

            @Override
            public void run() {
                MDC.setContextMap(context);
                log.info("haha3");
                MDC.clear();
            }
        }, Executors.newFixedThreadPool(4));
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                log.info("haha4");
            }
        }, Executors.newFixedThreadPool(4));
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                log.info("haha5");
            }
        }, Executors.newFixedThreadPool(4));

//        ActivityDO activity = new ActivityDO(id, "'test11'", ActivityTypeEnum.jumping, ActivityStatusEnum.END, null, null);
//
//        AcitivityMapper mapper = ApplicationContextUtil.getBean("acitivityMapper");
//        log.warn("select:{}", mapper.selectByType(ActivityTypeEnum.jumping));
//        ActivityDO activityDO = new ActivityDO();
//        activityDO.setName("test1");
//        activityDO.setType(ActivityTypeEnum.jumping);
//        activityDO.setStatus(ActivityStatusEnum.DELETE);
//        activityDO.setStartTime(new Date());
//        activityDO.setEndTime(new Date());
//        log.warn("select:{}", acitivityMapper.insert(activityDO));
        return "ok1难：" + test;
    }


    @RequestMapping("/cache")
    public String cache(@RequestParam("value") String value) {

        log.info("set cache:{}", cacheManager.cacheValue("test11", value, 3L));
        return cacheManager.getValue("test11");
    }


    @RequestMapping("/validate")
    public String validate(@RequestParam("value") String value) {

        log.info("set cache:{}", cacheManager.cacheValue("test11", value, 3L));
        return cacheManager.getValue("test11");
    }
}
