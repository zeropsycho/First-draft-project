package com.test.test;

import com.test.util.TransformationUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/**
 * json转换工具
 */
public class JsonTransformation {

    private TransformationUtil transformationUtil = new TransformationUtil();

    public static void getMap() {
        Map<String, Object> hashMap = new HashMap<>();

        String json = "{\n" +
                "\t\"one\": \"one\",\n" +
                "\t\"two\": \"two\",\n" +
                "\t\"three\": \"three\"\n" +
                "}";
        JSONObject jsonObject = new JSONObject(json); //json

        Iterator<String> iterable = jsonObject.keys();
        String key = null;
        Object value = null;
        while (iterable.hasNext()) {
            key = iterable.next();
            System.out.println("对应key：" + key);
            value = jsonObject.get(key);
            System.out.println("value值为：" + value);

            hashMap.put(key,value);
        }

        //map遍历
        System.out.println("Map遍历：");
        for (String s : hashMap.keySet()) {
            System.out.println(hashMap.get(s));
        }

        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }

    }


    public static void main(String[] args) {
        getMap();
    }

    @Test
    public void mapTransFormatJson() {
        Map<String, String> hashMap = new HashMap<>();

        hashMap.put("json1","json1");
        hashMap.put("json2","json2");
        System.out.println(transformationUtil.mapFormatJson(hashMap).toString());
    }


    /**
     * 测试
     */
    @Test
    public void jsonObject() {
        TransformationUtil transformationUtil = new TransformationUtil();
        String json = "{'json1':'json1','json2':'json2'}";
        net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(json);

        Map<String, ?> hashMap = transformationUtil.jsonFormatMap(jsonObject);
        for (Map.Entry h : hashMap.entrySet()) {
            System.out.println("key值：" + h.getKey() + "" +
                    "\nvalue：" + h.getValue());
        }
    }
}
