package com.cxh.sj.cxh.service;

import com.cxh.sj.cxh.mapper.CetTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author 米冠男
 * @Company miTeach.China.com
 * @date 2020/4/1 9:39
 * @Description
 */
@Service
public class CetTimeService {
    @Autowired
    private CetTimeMapper cetTimeMapper;

    //查询考试时间
    public List<HashMap> selectTime(){
        List<HashMap> hashMaps = cetTimeMapper.selectAllTime();
        if (hashMaps.size()>0){
            return hashMaps;
        }return null;
    }

    //修改考试时间
    public int updateTime(HashMap hashMap){
        int i = cetTimeMapper.resultTime(hashMap);
        if (i>0){
            return i;
        }return 0;
    }
}
