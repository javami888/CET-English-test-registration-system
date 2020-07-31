package com.cxh.sj.cxh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface IframeMapper {

    //获取四六级考试的时间
    @Select("select type,date_format(starttime,'%Y-%m-%d %H:%i:%s') starttime," +
            " date_format(stoptime,'%Y-%m-%d %H:%i:%s') stoptime from exatime ")
    List<Map<String,Object>> selectexatime();

    //获取公告信息
    @Select("select * from notice")
    Map<String,Object> selectnotice();

}
