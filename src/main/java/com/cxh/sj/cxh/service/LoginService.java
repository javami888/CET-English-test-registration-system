package com.cxh.sj.cxh.service;

import com.cxh.sj.cxh.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;
    //用户登录 查看是否有此人
    public Map getLoginId(Map map){
        return loginMapper.getLoginId(map);
    }

    //根据账号的id获取用户的信息
    public Map<String, Object> getEmpById(int id) {
        return loginMapper.getEmpById(id);
    }

    //根据id获取用户的权限信息
    public List<Map<String, Object>> getPermissionByRid(int rid) {
        List<Map<String, Object>> list = loginMapper.getFatherPermissionById(rid);
        if(list.size()>0){
            return list;
        }
        return null;
    }
    //根据id获取用户的职位
    public Map<String,Object> getShowStaffInfo(Integer id){
        Map<String, Object> showStaffInfo = loginMapper.getShowStaffInfo(id);
        if(null != showStaffInfo){
            return showStaffInfo;
        }
        return null;
    }
    //根据id获取用户的个人信息
    public Map<String,Object> getShowinfo(Integer id){
        Map<String, Object> showinfo = loginMapper.getShowinfo(id);
        if(null != showinfo){
            return showinfo;
        }
        return null;
    }

    //根据id修改用户的手机号码
    public int updatePhoneById(Map map){
        int res = loginMapper.updatePhoneById(map);
        if(res > 0){
            return res;
        }
        return 0;
    }
}
























































