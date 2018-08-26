package com.example.demo.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.dto.ExcelEntering;
import com.example.demo.service.ExcelService;
import com.example.demo.util.ExcelUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ZERO
 * @Date 2018-08-04
 */
@Service
public class ExcelServiceImpl implements ExcelService {

    @Override
    public void importExcel() {

    }

    @Override
    public void exportExcel(HttpServletResponse httpServletResponse) {
        //属性列头
        Map<String, Object> map = new HashMap<>();
        // 日期格式
        int count = 5;
        String format = "yyyy-MM-dd";
        JSONArray json = new JSONArray();
        for (int i = 0; i < count; i++) {
            ExcelEntering s = new ExcelEntering();
            s.setName("POI" + i);
            s.setAge(i);
            s.setBirthday(new Date());
            s.setHeight(i);
            s.setWeight(i);
            s.setSex(i / 2 == 0 ? new Byte("1") : new Byte("0"));
            json.add(s);
        }
        Map<String, String> headMap = new LinkedHashMap<String, String>();
        headMap.put("name", "姓名1");
        headMap.put("age", "年龄");
        headMap.put("birthday", "生日");
        headMap.put("height", "身高");
        headMap.put("weight", "体重");
        headMap.put("sex", "性别");

        String title = "测试";
        ExcelUtil.downloadExcelFile(title, headMap, json, httpServletResponse);

    }
}
