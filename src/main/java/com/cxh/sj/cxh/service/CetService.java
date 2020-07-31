package com.cxh.sj.cxh.service;

import com.cxh.sj.cxh.mapper.CetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class CetService {

    @Autowired
    private CetMapper cetMapper;

    //通过四级审核
    public int updateState(Integer id){
        int i = cetMapper.updateState(id);
        if (i>0) {
            return i;
        }return 0;

    }
    //通过六级审核
    public int updateSixState(Integer id){
        int i = cetMapper.updateSixState(id);
        if (i>0) {
            return i;
        }return 0;

    }



    //查询四级信息
    public List<HashMap> selectFourEnglish(){
        List<HashMap> hashMaps = cetMapper.selectFourEnglish();
        if(hashMaps.size() > 0 ){
            return hashMaps;
        }return null;
    };

    //查询六级信息
    public   List<HashMap>  selectSixEnglish(){
        List<HashMap> hashMaps = cetMapper.selectSixEnglish();
        if(hashMaps.size() > 0 ){
            return hashMaps;
        }return null;
    };

}
