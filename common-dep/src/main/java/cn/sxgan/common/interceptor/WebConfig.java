package cn.sxgan.common.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 添加自定义拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AllRequestInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/v3/api-docs");
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/email/auth")
                .excludePathPatterns("/v3/api-docs")
                .excludePathPatterns("/card/auth/signin")
                .excludePathPatterns("/card/auth/signup")
                .excludePathPatterns("/card/auth/mailVerifyCode")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/play/**");
    }
}