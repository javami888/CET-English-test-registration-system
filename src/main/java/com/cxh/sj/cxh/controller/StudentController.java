package com.cxh.sj.cxh.controller;

import com.cxh.sj.cxh.model.ResultData;
import com.cxh.sj.cxh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;


    /**
     * @Description:
     * @Param: [request]
     * @Author: mi
     * @Return: com.cxh.sj.cxh.model.ResultData
     * @Date: 2020/6/16 10:15
     **/
    @PostMapping("selectStuinfo")
    public ResultData selectStuinfo(HttpServletRequest request){
        Map login = (Map)request.getSession().getAttribute("login");
        String stuid = (String) login.get("stuid");
        Map<String, Object> stringObjectMap = studentService.selectStuinfo(stuid);
        if(stringObjectMap.size()>0){
            return new ResultData(200,"获取用户信息成功",stringObjectMap);
        }
        return new ResultData(400,"获取用户信息失败",null);
    }

    //根据学号修改用户密码
    @PostMapping("updatePwd")
    public ResultData updatePwd(String password, HttpServletRequest request){
        HashMap login = (HashMap)request.getSession().getAttribute("login");
        System.out.println(login);
        String stuid = (String) login.get("stuid");
        int i = studentService.updatePwd(password,stuid);
        System.out.println(password+stuid);
        if (i>0) {
            return new ResultData(200,"修改成功",i);
        }return new ResultData(400,"修改失败，请重试",0);
    }

    //修改用户的个人信息
    @PostMapping("updateStuinfo")
    public ResultData updateStuinfo(@RequestBody Map map){
        int res = studentService.updateStuinfo(map);
        if(res>0){
            return new ResultData(200,"修改用户信息成功",res);
        }
        return new ResultData(400,"修改用户信息失败",null);
    }

    //报名四级考试
    @PostMapping("baomingcetfour")
    public ResultData baomingcetfour(@RequestBody Map map,HttpServletRequest request){
        //获取四六级报名表中的数据，看是否有此用户报名，假如没有可以报名，假如有，不能报名
        //获取学号
        Map login = (Map)request.getSession().getAttribute("login");
        String stuid = (String) login.get("stuid");

        int res = studentService.insertCetfour(map,"123");
        if(res ==1 ){
            return new ResultData(200,"报名四级考试成功",res);
        }else if(res ==2 ) {
            return new ResultData(400,"请不要重复报名",res);
        }else if(res==3){
            return new ResultData(400,"当前时间不是报名时间，请在规定时间内报名！",res);
        }
        return new ResultData(400,"报名四级考试失败",null);
    }

    //报名六级考试
    @PostMapping("baomingcetsix")
    public ResultData baomingcetsix(@RequestBody Map map,HttpServletRequest request){
        //获取用户的四级成绩
        Map login = (Map)request.getSession().getAttribute("login");
        String stuid = (String) login.get("stuid");
        Map<String, Object> stringObjectMap = studentService.selectStuinfo(stuid);
        int fourresults = (int) stringObjectMap.get("fourresults");
        //判断四级成绩是否大于425分，大于的话可以报六级
        if(fourresults>425){
            int res = studentService.insertCetsix(map, stuid);
            if(res ==1 ){
                return new ResultData(200,"报名六级考试成功",res);
            }else if(res ==2 ) {
                return new ResultData(400,"请不要重复报名",res);
            }else if(res == 3){
                return new ResultData(400,"当前时间不是报名时间，请在规定时间内报名！",res);
            }
            return new ResultData(400,"报名六级考试失败",null);
        }else {
            return new ResultData(400,"你没有资格报名六级考试",null);
        }
    }










}
