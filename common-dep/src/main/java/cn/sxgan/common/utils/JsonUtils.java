package cn.sxgan.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Description: Json处理工具
 * @Author: sxgan
 * @Date: 2024-07-17 20:22
 * @Version: 1.0
 **/

public class JsonUtils {
    
    /**
     * 将对象转换为json字符串
     *
     * @param object
     * @return json字符串
     */
    public static String toJsonString(Object object) {
        ObjectMapper om = new ObjectMapper();
        String result = "";
        try {
            result = om.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    
    /**
     * 将json字符串转换为对象
     *
     * @param json  json
     * @param clazz 对象类型
     * @param <T>   转换类型声明
     * @return 对象
     */
    public static <T> T parseObject(String json, Class<T> clazz) {
        ObjectMapper om = new ObjectMapper();
        T result = null;
        try {
            result = om.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    
}
