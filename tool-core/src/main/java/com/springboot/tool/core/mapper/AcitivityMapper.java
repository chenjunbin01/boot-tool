package com.springboot.tool.core.mapper;

import com.springboot.tool.core.model.dataobj.ActivityDO;
import com.springboot.tool.core.model.enums.ActivityTypeEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author chenjunbin
 * @Date 2019/6/5
 * @Description
 */
public interface AcitivityMapper {
    @Select("SELECT * from boot_activity limit 100")
    List<ActivityDO> select();

    @Select("SELECT * from boot_activity where type = #{type}")
    List<ActivityDO> selectByType(@Param("type") ActivityTypeEnum type);


    @Select("SELECT * from boot_activity where id = #{id}")
    ActivityDO selectById(@Param("id") Long id);

    @Update("update boot_activity " +
            "set name = #{activity.name} " +
            ", type = #{activity.type} " +
            ", status = #{activity.status} " +
//            ", start_time = #{activity.startTime} " +
//            ", end_time = #{activity.endTime} " +
            "where id = #{activity.id}")
    Long updateById(@Param("activity") ActivityDO activityDO);



    List<ActivityDO> selectXML();



    @Insert("insert into boot_activity(name,type,start_time,end_time,status) " +
            "values(#{name},#{type},#{startTime},#{endTime},#{status})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    long insert(ActivityDO activityDO);
}
