package cn.sxgan.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @Description: Jwt 工具类
 * @Author: sxgan
 * @Date: 2024/7/17 22:08
 * @Version: 1.0
 **/
public class JwtUtils {
    
    // 自定义密钥
    private static final String SIGN = "Y*(GY*G^&*%69g*()&";
    
    /**
     * 生成 Token
     *
     * @param map 自定义的载荷数据
     * @return 返回 Token
     */
    public static String createToken(Map<String, Object> map, String sign) {
        // 1.设置过期时间(默认 1 天过期)
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 1);
        
        // 2.创建 jwt builder，添加自定义的载荷数据
        JWTCreator.Builder builder = JWT.create();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            builder.withClaim(entry.getKey(), entry.getValue().toString());
        }
        
        // 3.生成 Token
        String token = builder.withExpiresAt(instance.getTime()) // 过期时间
                .sign(Algorithm.HMAC256(sign));// sign
        return token;
    }
    
    /**
     * 验证 Token 合法性
     *
     * @param token
     */
    public static boolean checkToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    
    /**
     * 获取 Token 信息
     *
     * @param token
     * @return
     */
    public static DecodedJWT getTokenInfo(String token) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
        return verify;
    }
    
}