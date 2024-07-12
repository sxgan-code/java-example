package cn.sxgan.base.auth.entity;

import jakarta.servlet.http.HttpServletRequest;

/**
 * @Description: 请求持有实体，用于存放每次请求
 * @Author: sxgan
 * @Date: 24/7/12 17:34
 * @Version: 1.0
 **/
public class RequestHolder {
    private static final ThreadLocal<UserSessionInfo> userHolder = new ThreadLocal<UserSessionInfo>();
    
    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();
    
    public static void add(UserSessionInfo sysUser) {
        userHolder.set(sysUser);
    }
    
    public static void add(HttpServletRequest request) {
        requestHolder.set(request);
    }
    
    public static UserSessionInfo getCurrentUser() {
        return userHolder.get();
    }
    
    public static HttpServletRequest getCurrentRequest() {
        return requestHolder.get();
    }
    
    public static void remove() {
        userHolder.remove();
        requestHolder.remove();
    }
}