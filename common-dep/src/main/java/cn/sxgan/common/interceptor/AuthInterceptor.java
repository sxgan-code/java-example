package cn.sxgan.common.interceptor;


import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import cn.sxgan.common.exception.ExceptionStatus;
import cn.sxgan.common.response.ResponseResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description: 用户验证拦截器
 * @Author: sxgan
 * @Date: 2024/3/1 15:16
 * @Version: 1.0
 **/
@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getHeader("Authorization");
        if (StrUtil.isBlank(token)) {
            log.warn("The token is not pass");
            returnLogin(response);
            return false;
        }
        if (!token.equals("pass")) {
            log.warn("The token is not pass");
            returnLogin(response);
            return false;
        }
        return true;
    }
    
    /**
     * 设置验证失败，跳转登陆
     *
     * @param response
     * @throws IOException
     */
    private void returnLogin(HttpServletResponse response) throws IOException {
        log.warn("The request is not login");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        response.setStatus(200); // 权限不足
        writer.write(JSONUtil.toJsonStr(
                ResponseResult.fail(
                        null,
                        ExceptionStatus.EXCEPTION_STATUS_700.getExceptionCode(),
                        ExceptionStatus.EXCEPTION_STATUS_700.getExceptionMsg())));
    }
    
    
}