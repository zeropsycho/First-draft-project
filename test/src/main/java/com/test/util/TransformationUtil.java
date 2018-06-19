package com.test.util;

import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TransformationUtil {



    /**
     * json转Map
     * @param jsonObject json对象
     * @return Map
     */
    public Map<String, ?> jsonFormatMap(JSONObject jsonObject) {
        Map<String, String> hashMap = hashMap = new HashMap<>();;
        if (jsonObject != null) {
            String key = null;
            String value = null;
            Iterator iterator = jsonObject.keys();
            while (iterator.hasNext()) {
                key = iterator.next() + "";
                value = jsonObject.get(key) + "";
                hashMap.put(key, value);
            }
        }
        return hashMap;
    }

    /**
     * map转换为JSONObject
     * @param hashMap map对象
     * @return 返回一个不为null的JSONObject对象
     */
    public JSONObject mapFormatJson(Map<String, String> hashMap) {
        JSONObject jsonObject = JSONObject.fromObject(hashMap);

        return jsonObject;
    }

}
