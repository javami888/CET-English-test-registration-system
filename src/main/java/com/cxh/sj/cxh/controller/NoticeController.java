package com.cxh.sj.cxh.controller;

import com.cxh.sj.cxh.model.ResultData;
import com.cxh.sj.cxh.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    //查询公告
    @PostMapping("selectNotice")
    public ResultData selectNotice(){
        List<HashMap> hashMaps = noticeService.selectNotice();
        if (hashMaps.size()>0){
            return new ResultData(200,"查询公告成功",hashMaps.get(0));
        }return new ResultData(400,"查询公告失败",null);
    }

    //修改公告
    @PostMapping("updateNotice")
    public ResultData updateNotice(@RequestBody HashMap hashMap){
        int i = noticeService.resultNotice(hashMap);
        if (i > 0){
            return new ResultData(200,"修改公告成功",i);
        }return new ResultData(400,"修改公告失败",null);
    }
}
