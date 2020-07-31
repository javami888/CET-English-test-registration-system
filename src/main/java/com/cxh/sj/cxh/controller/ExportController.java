package com.cxh.sj.cxh.controller;

import com.cxh.sj.cxh.service.CetService;
import com.cxh.sj.cxh.utils.ExportUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

/**
 * @author mi
 * @date 2020/4/11 15:37
 * @Description
 */
@RequestMapping("/export")
@RestController
public class ExportController {

    @Autowired
    private CetService cetService;


    @RequestMapping("/fourExport")
    public void fourExport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据
        List<HashMap> list = cetService.selectFourEnglish();

        //excel标题
        String[] title = {"四级报名id", "姓名", "性别", "院系","专业","学号","报名状态"};

        //excel文件名
        String fileName = "四级报名表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "四级信息表";

        String [][] content = new String[list.size()][7];

        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            HashMap obj = list.get(i);
            content[i][0] = obj.get("id").toString();
            content[i][1] = (String) obj.get("name");
            content[i][2] = (String) obj.get("sex");
            content[i][3] = obj.get("faculty").toString();
            content[i][4] = obj.get("profession").toString();
            content[i][5] = obj.get("stuid").toString();
            content[i][6] = obj.get("state").toString();

        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExportUtil.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/sixExport")
    public void sixExport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据
        List<HashMap> list = cetService.selectSixEnglish();

        //excel标题
        String[] title = {"六级报名id", "姓名", "性别", "院系","专业","学号","报名状态"};

        //excel文件名
        String fileName = "六级报名表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "六级信息表";

        String [][] content = new String[list.size()][7];

        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            HashMap obj = list.get(i);
            content[i][0] = obj.get("id").toString();
            content[i][1] = (String) obj.get("name");
            content[i][2] = (String) obj.get("sex");
            content[i][3] = obj.get("faculty").toString();
            content[i][4] = obj.get("profession").toString();
            content[i][5] = obj.get("stuid").toString();
            content[i][6] = obj.get("state").toString();

        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExportUtil.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 发送响应流方法
     */
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
