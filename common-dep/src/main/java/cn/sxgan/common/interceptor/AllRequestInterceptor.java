package cn.sxgan.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Description: 全局请求皆拦截
 * @Author: sxgan
 * @Date: 2024/3/1 15:16
 * @Version: 1.0
 **/
@Slf4j
public class AllRequestInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 如果不是网关来的服务，都拒绝访问
        // String fromKey = request.getHeader("systemFrom");
        // if (fromKey == null || !fromKey.equals("gateway")) {
        //     log.warn("The request is not from the gateway");
        //     response.setContentType("application/json; charset=utf-8");
        //     PrintWriter writer = response.getWriter();
        //     response.setStatus(401); // 权限不足
        //     writer.write(JSONUtil.toJsonStr(ResponseResult.fail(ResponseStatus.HTTP_STATUS_401.getDescription())));
        //     return false;
        // }
        // log.info("The gateway origin permission is passed");
        //... 鉴权Token
        return true;
    }
}