package com.cxh.sj.cxh.controller;

import com.cxh.sj.cxh.model.ResultData;
import com.cxh.sj.cxh.service.CetTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/exatime")
public class CetTimeController {
    @Autowired
    private CetTimeService cetTimeService;

    //查询考试时间
    @PostMapping("selectTime")
    public ResultData selectTime(){
        List<HashMap> hashMaps = cetTimeService.selectTime();
        if (hashMaps.size()>0){
            return new ResultData(200,"查询成功",hashMaps);
        } return new ResultData(400,"查询失败",null);
    }

    //修改考试时间
    @PostMapping("updatetime")
    public ResultData updatetime(@RequestBody HashMap hashMap){

        String starttime = hashMap.get("starttime").toString();
        String replace = starttime.replace("T", " ");
        String aa = replace.replace(".000Z", "");
        hashMap.put("starttime",aa);

        String stoptime = hashMap.get("stoptime").toString();
        String replace1 = stoptime.replace("T", " ");
        String aa1 = replace1.replace(".000Z", "");
        hashMap.put("stoptime",aa1);


        int i = cetTimeService.updateTime(hashMap);
        if (i>0){
            return new ResultData(200,"修改成功",i);
        }return new ResultData(400,"修改失败",0);
    }
}
