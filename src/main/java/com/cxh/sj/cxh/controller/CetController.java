package com.cxh.sj.cxh.controller;

import com.cxh.sj.cxh.model.ResultData;
import com.cxh.sj.cxh.service.CetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class CetController {

    @Autowired
    private CetService cetService;

    //1.获取四级报名信息
    @PostMapping("selectFourDetail")
    public ResultData selectFourDetail(){

        List<HashMap> hashMaps = cetService.selectFourEnglish();
        if ( hashMaps.size()>0 ){
            return new ResultData(200,"获取四级报名信息成功",hashMaps);
        }return  new ResultData(400,"获取四级报名信息失败",null);
    }

    //2.获取六级报名信息
    @PostMapping("selectSixDetail")
    public ResultData selectDetail(){
        List<HashMap> hashMaps = cetService.selectSixEnglish();
        if ( hashMaps.size()>0 ){
            return new ResultData(200,"获取六级报名信息成功",hashMaps);
        }return  new ResultData(400,"获取六级报名信息失败",null);
    }


    //3.通过四级审核
    @PostMapping("updateState")
    public ResultData updateState(Integer id){
        int i = cetService.updateState(id);
        if (i>0) {
            return new ResultData(200,"修改四级状态成功",i);
        }return  new ResultData(400,"修改状态失败",null);
    }

    //4.通过六级审核
    @PostMapping("updateSixState")
    public ResultData updateSixState(Integer id){
        int i = cetService.updateSixState(id);
        if (i>0) {
            return new ResultData(200,"修改六级状态成功",i);
        }return  new ResultData(400,"修改状态失败",null);
    }
}
