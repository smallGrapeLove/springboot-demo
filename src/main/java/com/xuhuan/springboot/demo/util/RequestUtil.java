package com.xuhuan.springboot.demo.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author huan.xu
 * @ClassName RequestUtil
 * @date 2021/1/8 10:27
 * @Description request工具类
 */
public class RequestUtil {

    public static Map transRequestParameterMap(Map<String, String[]> parameterMap) {
        Map<String, String> reMap = new HashMap();
        Iterator iterator = parameterMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String[]> entry = (Map.Entry) iterator.next();
            String key = entry.getKey();
            String[] values = entry.getValue();
            String value = "";
            if (values != null && values.length > 0) {
                //这里只去第一个元素，会不会有问题？ todo
                value = values[0];
            }
            reMap.put(key, value);
        }

        return reMap;
    }
}
