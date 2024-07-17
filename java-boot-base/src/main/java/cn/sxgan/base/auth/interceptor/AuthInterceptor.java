package cn.sxgan.base.auth.interceptor;


import cn.sxgan.base.auth.entity.RequestHolder;
import cn.sxgan.base.auth.entity.UserSessionInfo;
import cn.sxgan.common.cache.redis.RedisUtil;
import cn.sxgan.common.consts.RedisConst;
import cn.sxgan.common.enums.ResponseStatus;
import cn.sxgan.common.response.ResponseResult;
import cn.sxgan.common.utils.JsonUtils;
import cn.sxgan.common.utils.JwtUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 用户登录拦截器
 * @Author: sxgan
 * @Date: 24/7/12 16:41
 * @Version: 1.0
 **/
@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    
    @Resource
    RedisUtil redisUtil;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (StringUtils.isBlank(token) || !JwtUtils.checkToken(token)) {
            returnLogin(response);
            return false;
        }
        // 拦截器在bean初始化前执行的，这时候redisUtil是null，需要通过下面这个方式去获取
        if (redisUtil == null) {
            WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            redisUtil = wac.getBean(RedisUtil.class);
        }
        // 鉴权Token
        UserSessionInfo user = redisUtil.get(RedisConst.LOGIN_TOKEN_PREFIX + token, UserSessionInfo.class);
        log.info("current user = {}", user);
        if (user == null) {
            log.info("user is blank");
            returnLogin(response);
            return false;
        }
        RequestHolder.add(user);
        // 重置登陆时间
        redisUtil.set(RedisConst.LOGIN_TOKEN_PREFIX + token, user, RedisConst.LOGIN_TIME_1, TimeUnit.DAYS);
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
        writer.write(JsonUtils.toJsonString(ResponseResult.fail(null,
                ResponseStatus.EXCEPTION_STATUS_700.getCode(),
                ResponseStatus.EXCEPTION_STATUS_700.getMsg())));
    }
}