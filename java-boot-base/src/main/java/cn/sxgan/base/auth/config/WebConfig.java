package cn.sxgan.base.auth.config;

import cn.sxgan.base.auth.interceptor.AuthInterceptor;
import cn.sxgan.common.interceptor.AllRequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: 全局请求路径拦截器
 * @Author: sxgan
 * @Date: 24/7/12 17:33
 * @Version: 1.0
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 添加自定义拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AllRequestInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/v3/api-docs");
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/v3/api-docs")
                .excludePathPatterns("/auth/signin")
                .excludePathPatterns("/auth/signup")
                .excludePathPatterns("/auth/verifyCodeImg")
                .excludePathPatterns("/auth/mailVerifyCode");
    }
}