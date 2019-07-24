package com.springboot.tool.core.model.enums.handler;

/**
 * @Author chenjunbin
 * @Date 2019/6/13
 * @Description
 */
public interface BaseEnum<E extends Enum<?>, T> {

    T getValue();
}
