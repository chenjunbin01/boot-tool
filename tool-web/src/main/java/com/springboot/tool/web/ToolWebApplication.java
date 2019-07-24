package com.springboot.tool.web;

//import com.springboot.tool.core.config.SqlPrintInterceptor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(scanBasePackages = "com.springboot.tool", exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.springboot.tool.core.mapper")
// 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@EnableTransactionManagement
@EnableScheduling
//@ImportResource(locations = "classpath:datasource.xml")
public class ToolWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolWebApplication.class, args);
    }




}
