package cn.sxgan.common.utils;

import java.lang.reflect.Field;
import java.security.SecureRandom;

/**
 * @Description: 公共方法工具类
 * @Author: sxgan
 * @Date: 2024-05-19 11:43
 * @Version: 1.0
 **/
public class CommonUtils {
    
    private static final String CHAR_SET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final SecureRandom RANDOM = new SecureRandom();
    
    /**
     * 生成0-9，A-Z之间的随机字符串
     *
     * @param length 指定字符串长度
     * @return 返回生成字符串
     */
    public static String generateRandomCode(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }
        StringBuilder code = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            code.append(CHAR_SET.charAt(RANDOM.nextInt(CHAR_SET.length())));
        }
        return code.toString();
    }
    
    /**
     * 比较两个对象指定属性值是否完全相等
     *
     * @param object1    对象1
     * @param object2    对象2
     * @param fieldNames 需要比较的字段名
     * @return true/false
     */
    public static boolean compareObjects(Object object1, Object object2, String[] fieldNames) {
        if (object1 == object2) {
            return true;
        }
        if (object1 == null || object2 == null) {
            return false;
        }
        if (!object1.getClass().equals(object2.getClass())) {
            return false;
        }
        
        Field[] fields = object1.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                for (String fieldName : fieldNames) {
                    if (field.getName().equals(fieldName)) {
                        field.setAccessible(true);
                        Object value1 = field.get(object1);
                        Object value2 = field.get(object2);
                        if (value1 == null && value2 != null) {
                            return false;
                        }
                        if (value1 != null && value2 == null) {
                            return false;
                        }
                        if (value1 == null && value2 == null) {
                            continue;
                        }
                        if (!value1.equals(value2)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
    }
}
