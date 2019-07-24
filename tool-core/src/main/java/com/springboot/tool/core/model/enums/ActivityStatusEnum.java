package com.springboot.tool.core.model.enums;

import com.springboot.tool.core.model.enums.handler.BaseEnum;

/**
 * @Author chenjunbin
 * @Date 2019/6/13
 * @Description
 */
public enum ActivityStatusEnum implements BaseEnum<ActivityStatusEnum, Integer> {

    END(1, "结束"),
    NORMAL(0, "正常"),
    DELETE(-1, "删除");

    Integer value;
    String desc;

    ActivityStatusEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public Integer getValue() {
        return value;
    }
}
