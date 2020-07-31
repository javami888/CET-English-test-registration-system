package com.cxh.sj.cxh.service;

import com.cxh.sj.cxh.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    //获取用户的个人信息
    public Map<String,Object> selectStuinfo(String stuid){
        Map<String, Object> stringObjectMap = studentMapper.selectStuinfo(stuid);
        if(stringObjectMap.size()>0){
            return stringObjectMap;
        }else {
            return null;
        }
    }

    //根根学号修改密码
    public int updatePwd(String password,String stuid){
        int i = studentMapper.updatePwd(password,stuid);
        if (i>0) {
            return i;
        }
        return 0;
    }

    //根据学号修改个人信息
    public int updateStuinfo(Map map){
        int res = studentMapper.updateStuinfo(map);
        if(res>0){
            return res;
        }
        return 0;
    }





    //报名四级考试
    public int insertCetfour(Map map,String stuid){
        //先判断是否在规定时间内报名
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String nowtime= df.format(new Date());// new Date()为获取当前系统时间
        List<HashMap> stringObjectMap1 = studentMapper.selectTimeInfo(nowtime);
        if(null != stringObjectMap1 && stringObjectMap1.size()>0){
            //获取四级报名表中的数据，看是否有此用户报名，假如没有可以报名，假如有，不能报名
            Map<String, Object> stringObjectMap = studentMapper.selectCetfourBystuid(stuid);
            if(null == stringObjectMap){
                int res = studentMapper.insertCetfour(map);
                if(res>0){
                    return res;
                }
                return 0;
            }else {
                return 2;
            }
        }
        return 3;
    }

    //报名六级考试
    public int insertCetsix(Map map,String stuid){
        //先判断是否在规定时间内报名
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String nowtime= df.format(new Date());// new Date()为获取当前系统时间
        List<HashMap> stringObjectMap1 = studentMapper.selectSixTimeInfo(nowtime);
        if(null != stringObjectMap1 &&stringObjectMap1.size()>0) {
            //获取六级报名表中的数据，看是否有此用户报名，假如没有可以报名，假如有，不能报名
            Map<String, Object> stringObjectMap = studentMapper.selectCetsixBystuid(stuid);
            if (null == stringObjectMap) {
                int res = studentMapper.insertCetsix(map);
                if (res > 0) {
                    return res;
                }
                return 0;
            } else {
                return 2;
            }
        }
        return 3;
    }





}
