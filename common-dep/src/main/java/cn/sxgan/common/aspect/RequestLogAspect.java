package cn.sxgan.common.aspect;

import cn.sxgan.common.utils.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.support.MultipartFilter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description: 请求日志打印切面
 * @Author: sxgan
 * @Date: 2024/6/22 11:54
 * @Version: 1.0
 **/
@Slf4j
@Aspect
@Component
public class RequestLogAspect {
    
    /**
     * 请求Before切入点
     */
    @Pointcut("@annotation(cn.sxgan.common.anno.RequestBeforeLog)")
    public void beforePointcut() {
    }
    
    /**
     * 请求Around切入点
     */
    @Pointcut("@annotation(cn.sxgan.common.anno.RequestAroundLog)")
    public void aroundPointcut() {
    }
    
    
    /**
     * 记录请求日志的切面
     *
     * @param joinPoint
     */
    @Before("beforePointcut()")
    public void doBefore(JoinPoint joinPoint) {
        try {
            addLog(joinPoint, "", 0);
        } catch (Exception e) {
            log.error("doBefore日志记录异常，异常信息为:", e);
        }
    }
    
    /**
     * 记录请求和响应日志的切面
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("aroundPointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Object result = null;
        try {
            long startTime = System.currentTimeMillis();
            result = joinPoint.proceed(args);
            long endTime = System.currentTimeMillis();
            long time = endTime - startTime;
            // 将对象转换为JSON字符串
            addLog(joinPoint, JsonUtils.toJsonString(result), time);
        } catch (Exception e) {
            log.error("doAround日志记录异常，异常信息为:", e);
            throw e;
        }
        return result;
    }
    
    /**
     * 日志记录入库操作
     */
    public void addLog(JoinPoint joinPoint, String outParams, long time) throws JsonProcessingException {
        HttpServletRequest request = ((ServletRequestAttributes)
                Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        log.info("\n\r=======================================\n\r" +
                        "请求地址:{} \n\r" +
                        "请求方式:{} \n\r" +
                        "请求类方法:{} \n\r" +
                        "请求方法参数:{} \n\r" +
                        "返回报文:{} \n\r" +
                        "处理耗时:{} ms \n\r" +
                        "=======================================\n\r",
                request.getRequestURI(),
                request.getMethod(),
                joinPoint.getSignature(),
                JsonUtils.toJsonString(filterArgs(joinPoint.getArgs())),
                outParams,
                time
        );
    }
    
    /**
     * 过滤参数
     *
     * @param args
     * @return
     */
    private List<Object> filterArgs(Object[] args) {
        return Arrays.stream(args).filter(object -> !(object instanceof MultipartFilter)
                && !(object instanceof HttpServletRequest)
                && !(object instanceof HttpServletResponse)
        ).collect(Collectors.toList());
    }
    
    
}
