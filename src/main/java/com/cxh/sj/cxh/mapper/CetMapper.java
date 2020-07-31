package com.cxh.sj.cxh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CetMapper {

    //查询四级信息
    @Select("select * from cetfour")
    List<HashMap>  selectFourEnglish();

    //查询六级信息
    @Select("select * from cetsix")
    List<HashMap>  selectSixEnglish();

    //学生四级考试通过
    @Update("update cetfour set state = 2 where id = #{id}")
    int updateState(Integer id);

    //学生六级考试通过
    @Update("update cetsix set state = 2 where id = #{id}")
    int updateSixState(Integer id);


}
