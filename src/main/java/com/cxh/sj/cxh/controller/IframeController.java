package com.cxh.sj.cxh.controller;


import com.cxh.sj.cxh.model.ResultData;
import com.cxh.sj.cxh.service.IframeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/iframe")
public class IframeController {
    @Autowired
    private IframeService iframeService;

    //获取四六级考试的时间
    @PostMapping("selectexatime")
    public ResultData selectexatime(){
        List<Map<String, Object>> selectexatime = iframeService.selectexatime();
        if(null != selectexatime &&selectexatime.size()>0){
            return new ResultData(200,"获取四六级考试时间成功",selectexatime);
        }
        return new ResultData(400,"获取四六级考试时间失败",null);
    }

    //获取公告
    @PostMapping("selectnotice")
    public ResultData selectnotice(){
        Map<String, Object> selectnotice = iframeService.selectnotice();
        if(null != selectnotice &&selectnotice.size()>0){
            return new ResultData(200,"获取公告成功",selectnotice);
        }
        return new ResultData(400,"获取公告失败",null);
    }
}
