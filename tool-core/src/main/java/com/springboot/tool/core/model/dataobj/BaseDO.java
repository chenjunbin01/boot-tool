package com.springboot.tool.core.model.dataobj;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author chenjunbin
 * @Date 2019/6/5
 * @Description
 */
public class BaseDO implements Serializable{
    private static final long serialVersionUID = -8385748169249582886L;

    private Date createTime;

    private Date updateTime;
}
