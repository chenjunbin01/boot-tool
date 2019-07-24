package com.springboot.tool.core.model.enums;

import com.springboot.tool.core.model.enums.handler.BaseEnum;

/**
 * @Author chenjunbin
 * @Date 2019/6/13
 * @Description
 */
public enum ActivityTypeEnum implements BaseEnum<ActivityTypeEnum, Long> {

    jumping(1L, "跳高"),
    running(0L, "跑步");

    Long value;
    String desc;

    ActivityTypeEnum(Long value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public Long getValue() {
        return value;
    }
}
