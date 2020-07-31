package com.cxh.sj.cxh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CetTimeMapper {
    //查询四六级时间
    @Select("select id,type,date_format(starttime,'%Y-%m-%d %H:%i:%s') starttime,date_format(stoptime,'%Y-%m-%d %H:%i:%s') stoptime from exatime")
    List<HashMap> selectAllTime();

    //修改时间
    @Update("update exatime set starttime = #{starttime},stoptime = #{stoptime} where id = #{id}")
    int resultTime(HashMap exatime);
}
