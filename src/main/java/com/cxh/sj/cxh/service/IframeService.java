package com.cxh.sj.cxh.service;

import com.cxh.sj.cxh.mapper.IframeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IframeService {
    @Autowired
    private IframeMapper iframeMapper;

    //获取四六级考试的时间
    public List<Map<String,Object>> selectexatime(){
        List<Map<String, Object>> selectexatime = iframeMapper.selectexatime();
        if(null != selectexatime &&selectexatime.size()>0){
            return selectexatime;
        }
        return null;
    }

    //获取公告的信息
    public Map<String,Object> selectnotice(){
        Map<String, Object> selectnotice = iframeMapper.selectnotice();
        if(null != selectnotice &&selectnotice.size()>0){
            return selectnotice;
        }
        return null;
    }
}
