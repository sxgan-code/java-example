package cn.sxgan.common.utils;

import java.security.SecureRandom;

/**
 * @Description: 密码加密工具
 * @Author: sxgan
 * @Date: 24/7/12 15:57
 * @Version: 1.0
 **/
public class PasswordEncoderUtils {
    
    private final static String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    
    public static String encode(String password) {
        // 生成盐
        String salt = generateSalt(20);
        // 加密
        return encode(password, salt);
    }
    
    public static String encode(String password, String salt) {
        // 加密
        return salt + "@" + Md5Util.getMD5String(password + salt);
    }
    
    public static Boolean matches(String encodedPassword, String rawPassword) {
        if (encodedPassword == null || rawPassword == null) {
            return false;
        }
        if (!encodedPassword.contains("@")) {
            throw new RuntimeException("密码格式不正确！");
        }
        String[] arr = encodedPassword.split("@");
        // 获取盐
        String salt = arr[0];
        // 比较
        return encodedPassword.equals(encode(rawPassword, salt));
    }
    
    /**
     * 根据长度及字符集生成随机盐值
     *
     * @param size  长度
     * @param chars 字符集
     * @return 盐值
     */
    public static String generateSalt(Integer size, String chars) {
        StringBuilder salt = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < size; i++) {
            salt.append(chars.charAt(secureRandom.nextInt(chars.length())));
        }
        return salt.toString();
    }
    
    /**
     * 根据长度生成随机盐值
     *
     * @param size 盐值长度
     * @return 盐值
     */
    public static String generateSalt(Integer size) {
        return generateSalt(size, CHARS);
    }
}