package cn.sxgan.common.utils;

import org.apache.commons.lang3.StringUtils;

public class StrUtils {
    
    /**
     * 去除字符串两端指定的字符
     *
     * @param str          待处理的字符串
     * @param charToRemove 要去除的字符
     * @return 去除两端指定字符后的字符串
     */
    public static String trim(String str, char charToRemove) {
        int start = 0, end = str.length() - 1;
        // 去除开头的指定字符
        while (start <= end && str.charAt(start) == charToRemove) {
            start++;
        }
        // 去除结尾的指定字符
        while (start <= end && str.charAt(end) == charToRemove) {
            end--;
        }
        // 返回去除后的字符串
        return str.substring(start, end + 1);
    }
    
    /**
     * 将下划线分隔的字符串转换为驼峰命名法
     *
     * @param str
     * @param separator
     * @return
     */
    public static String underscoreToAllCamelCase(String str, String separator) {
        if (str == null || StringUtils.isBlank(str)) {
            return str;
        }
        String[] words = str.split(separator);
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (StringUtils.isBlank(word)) {
                break;
            }
            result.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase());
            
        }
        return result.toString();
    }
}