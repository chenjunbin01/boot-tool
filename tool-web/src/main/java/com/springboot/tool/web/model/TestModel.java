package com.springboot.tool.web.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author chenjunbin
 * @Date 2019/6/4
 * @Description
 */
@Data
@Component
@ConfigurationProperties(prefix="test")
public class TestModel {

    private String name;

    private Integer age;

    private String sex;



}
