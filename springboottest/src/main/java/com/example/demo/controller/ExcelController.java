package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.enums.ReturnParam;
import com.example.demo.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.common.RequestParam;

import javax.servlet.http.HttpServletResponse;

/**
 * 表格导入的参数
 * @author ZERO
 * @date 2018-08-05 12:20
 */
@RestController
@RequestMapping(value = RequestParam.EXCEL_DEFALUT)
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @PostMapping(value = "/import")
    public ReturnParam importExcel(HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        excelService.exportExcel(response);
        return null;
    }

    @GetMapping(value = "/excel")
    public String test() {
        return "success";
    }
}
