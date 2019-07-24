package com.springboot.tool.core.model.enums.handler;

import com.springboot.tool.core.model.enums.ActivityStatusEnum;
import com.springboot.tool.core.model.enums.ActivityTypeEnum;
import org.apache.ibatis.type.MappedTypes;

/**
 * @Author chenjunbin
 * @Date 2019/6/13
 * @Description
 */
@MappedTypes(value = {ActivityStatusEnum.class, ActivityTypeEnum.class})
public class SystemEnumHandler<E extends Enum<E> & BaseEnum> extends BaseEnumHandler<E> {
    public SystemEnumHandler(Class<E> type) {
        super(type);
    }
}
