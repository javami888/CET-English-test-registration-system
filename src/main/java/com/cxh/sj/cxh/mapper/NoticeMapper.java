package com.cxh.sj.cxh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

/**
 * @author 米冠男
 * @Company miTeach.China.com
 * @date 2020/4/1 9:37
 * @Description
 */
@Mapper
public interface NoticeMapper {
    //查询所有公告
    @Select("select * from notice")
    List<HashMap> selectNotice();

    //管理公告
    @Update("update notice set name=#{name},content=#{content} where id = 1")
    int resultNotice(HashMap notice);

}
