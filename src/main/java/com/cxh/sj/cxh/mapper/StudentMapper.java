package com.cxh.sj.cxh.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    //获取个人信息
    @Select("select * from perinfo where stuid =#{stuid}")
    Map<String,Object> selectStuinfo(String stuid);


    //修改密码
    @Update("update login set password = #{password} where username = #{stuid}")
    int updatePwd(String password,String stuid);

    //修改个人信息
    @Update("update perinfo set name=#{name},sex=#{sex},faculty=#{faculty},profession=#{profession} where stuid=#{stuid}")
    int updateStuinfo(Map map);

    //通过学号查询四级是否已经报名
    @Select("select * from cetfour where stuid=#{stuid}")
    Map<String,Object> selectCetfourBystuid(String stuid);

    //学生报名四级考试
    @Insert("insert into cetfour values (null,#{name},#{sex},#{faculty},#{profession},#{stuid},1 )")
    int insertCetfour(Map map);

    //通过学号查询六级是否已经报名
    @Select("select * from cetsix where stuid=#{stuid}")
    Map<String,Object> selectCetsixBystuid(String stuid);

    //学生报名六级考试
    @Insert("insert into cetsix values (null,#{name},#{sex},#{faculty},#{profession},#{stuid},1 )")
    int insertCetsix(Map map);

    //根据当前时间查询四级数据
    @Select("SELECT * from exatime where #{nowtime} BETWEEN (SELECT starttime from exatime WHERE id =1 " +
            ") AND (SELECT stoptime from exatime WHERE id =1 " +
            ")")
    List<HashMap> selectTimeInfo(String nowtime);

    //根据当前时间查询四级数据
    @Select("SELECT * from exatime where #{nowtime} BETWEEN (SELECT starttime from exatime WHERE id =2 " +
            ") AND (SELECT stoptime from exatime WHERE id =2 " +
            ")")
    List<HashMap> selectSixTimeInfo(String nowtime);


}
