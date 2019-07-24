package com.springboot.tool.core.model.dataobj;

import com.springboot.tool.core.model.enums.ActivityStatusEnum;
import com.springboot.tool.core.model.enums.ActivityTypeEnum;
import lombok.Data;

import java.util.Date;

/**
 * @Author chenjunbin
 * @Date 2019/6/4
 * @Description
 */
@Data
public class ActivityDO extends BaseDO {

    private Long id;
    private String name;
    private ActivityTypeEnum type;
    private ActivityStatusEnum status;
    private Date startTime;
    private Date endTime;


    public ActivityDO() {
    }

    public ActivityDO(Long id, String name, ActivityTypeEnum type, ActivityStatusEnum status, Date startTime, Date endTime) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
