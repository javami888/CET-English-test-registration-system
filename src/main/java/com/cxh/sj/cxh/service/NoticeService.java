package com.cxh.sj.cxh.service;

import com.cxh.sj.cxh.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author 米冠男
 * @Company miTeach.China.com
 * @date 2020/4/1 9:38
 * @Description
 */
@Service
public class NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    //管理公告
    public  int resultNotice(HashMap notice){
        int i = noticeMapper.resultNotice(notice);
        if( i > 0 ){
            return i;
        }return 0;
    };

    //查询所有公告
    public List<HashMap> selectNotice(){
        List<HashMap> hashMaps = noticeMapper.selectNotice();
        if (hashMaps.size()>0){
            return hashMaps;
        }return null;
    }
}
