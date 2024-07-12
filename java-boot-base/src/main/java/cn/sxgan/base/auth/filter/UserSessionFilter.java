package cn.sxgan.base.auth.filter;

import cn.sxgan.base.auth.entity.RequestHolder;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 用户登录过滤器，存入用户信息
 * @Author: sxgan
 * @Date: 24/7/12 16:38
 * @Version: 1.0
 **/
@WebFilter(filterName = "userSessionFilter", urlPatterns = "/*")
@Slf4j
public class UserSessionFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        RequestHolder.add(httpRequest);
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            log.error("用户登录过滤器异常");
        }
        
    }
}