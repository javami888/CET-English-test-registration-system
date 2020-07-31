package com.cxh.sj.cxh.controller;


import com.cxh.sj.cxh.model.ResultData;
import com.cxh.sj.cxh.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    //用户登录
    @PostMapping("denglu")
    public ResultData denglu(@RequestBody Map map, HttpServletRequest request){
        Map loginId = loginService.getLoginId(map);
        if(loginId != null){
            int id = (int) loginId.get("id");
            Map<String, Object> empById = loginService.getEmpById(id);
            request.getSession().setAttribute("login",empById);
            System.out.println(empById);
            int state = (int) empById.get("state");
            if(state == 1 ){
                return new ResultData(200,"用户登录成功",null);
            }else{
                return new ResultData(300,"账号被冻结",null);
            }
        }
        return new ResultData(400,"用户登录失败",null);
    }
    //获取登录用户的权限
    @PostMapping("getPermission")
    public ResultData getPermission(HttpServletRequest request){
        Map login = (Map) request.getSession().getAttribute("login");
        Integer roleID = (Integer) login.get("roleID");
        List<Map<String, Object>> permissionByRid = loginService.getPermissionByRid(roleID);
        if(permissionByRid.size()>0){
            return new ResultData(200,"权限获取成功",permissionByRid);
        }
        return new ResultData(400,"权限获取失败",null);
    }
    //获取用户的身份
    @GetMapping("showStaffInfo")
    public ResultData getShowStaffInfo(HttpServletRequest request){
        Map login = (Map) request.getSession().getAttribute("login");
        Integer id = (Integer) login.get("id");
        Map<String, Object> showStaffInfo = loginService.getShowStaffInfo(id);
        if(null != showStaffInfo){
            return new ResultData(200,"获取成功",showStaffInfo);
        }
        return new ResultData(400,"获取失败",null);
    }

    //获取用户的个人信息
    @GetMapping("showinfo")
    public ResultData getShowinfo(HttpServletRequest request){
        Map login = (Map) request.getSession().getAttribute("login");
        Integer id = (Integer) login.get("id");
        Map<String, Object> showinfo = loginService.getShowinfo(id);
        if(null != showinfo){
            return new ResultData(200,"获取员工信息成功",showinfo);
        }
        return new ResultData(400,"获取员工信息失败",null);
    }
    //根据id修改用户的个人信息
    @PostMapping("updateInfo")
    public ResultData updateInfo(@RequestBody Map map){
        int res = loginService.updatePhoneById(map);
            if(res>0){
                return new ResultData(200,"修改信息成功",null);
            }
            return new ResultData(400,"修改信息失败",null);
    }
    //退出当前登录
    @PostMapping("logout")
    public ResultData loginout(HttpServletRequest request){
        request.getSession().invalidate();
        return new ResultData(200,"退出成功",null);
    }
}


























