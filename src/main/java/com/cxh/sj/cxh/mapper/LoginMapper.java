package com.cxh.sj.cxh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface LoginMapper {
    //用户登录，查看是否有此人
    @Select("select * from login where username=#{username} and password=#{password}")
    Map<String, Object> getLoginId(Map map);

    //根据账号id获取用户信息
    @Select("select *  from employee where loginID = #{id} ")
    Map<String, Object> getEmpById(int id);

    //根据id获取权限
    @Select("select  DISTINCT p1.id, p1.name,p1.url urlPath  from  role_per  rp "+
            " inner  join   permission  p "+
            " on  rp.pid = p.id"+
            " inner  join   permission  p1 "+
            " on  p.parentid = p1.id "+
            " where rp.rid = #{roleID} ")
    List<Map<String,Object>> getFatherPermissionById(Integer roleID);


    //根据id获取用户的身份
    @Select("select emp.name,emp.portrait,dep.name dname from employee emp inner join department dep on emp.deptID = dep.id where emp.id = #{id}")
    Map<String, Object> getShowStaffInfo(Integer id);

    //根据id获取用户的个人信息
    @Select("select DATE_FORMAT(emp.hiredate,'%Y-%m-%d %H:%i:%S')hiredate,emp.id,emp.name,emp.telephone,emp.portrait from employee emp where id = #{id}")
    Map<String,Object> getShowinfo(Integer id);

    //根据id修改用户电话号码
    @Update("update employee set telephone = #{telephone} where id = #{id}")
    int updatePhoneById(Map map);

}




































