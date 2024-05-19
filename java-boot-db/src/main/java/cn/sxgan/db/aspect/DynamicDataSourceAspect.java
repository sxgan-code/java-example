package cn.sxgan.db.aspect;

import cn.sxgan.common.anno.UseDataSource;
import cn.sxgan.common.enums.DataSourceEnum;
import cn.sxgan.db.config.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description: 动态数据源切换切面类
 * @Author: sxgan
 * @Date: 2024-05-18 22:44
 * @Version: 1.0
 **/
@Slf4j
@Aspect
@Order(-1)
@Component
public class DynamicDataSourceAspect {
    
    // 切入点为Service下的所有以List结尾方法
    @Pointcut("execution(* cn.sxgan.common.service.impl.*.*List(..))")
    public void pointCut() {
    }
    
    /**
     * 切入点表示所有Service实现类中以List结尾的方法，采用随机选择查询某一个数据源
     *
     * @param joinPoint
     */
    @Before(value = "pointCut()")
    public void doBeforeWithSlave(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 获取当前切点方法对象
        Method method = methodSignature.getMethod();
        if (method.getDeclaringClass().isInterface()) {// 判断是否为借口方法
            try {
                // 获取实际类型的方法对象
                method = joinPoint.getTarget().getClass()
                        .getDeclaredMethod(joinPoint.getSignature().getName(), method.getParameterTypes());
            } catch (NoSuchMethodException e) {
                log.error("方法不存在！", e);
            }
        }
        if (null == method.getAnnotation(UseDataSource.class)) {
            DataSourceContextHolder.setSlave();
        }
    }
    
    /**
     * 利用UseDataSource注解的方法，在执行方法前更换数据源
     *
     * @param joinPoint     切点
     * @param useDataSource 动态数据源
     */
    @Before("@annotation(useDataSource)")
    public void doBefore(JoinPoint joinPoint, UseDataSource useDataSource) {
        DataSourceEnum dataSourceKey = useDataSource.dataSourceKey();
        DataSourceContextHolder.set(dataSourceKey);
    }
    
    /**
     * 利用UseDataSource注解的方法，在执行方法后清除数据源设置
     *
     * @param joinPoint     切点
     * @param useDataSource 动态数据源
     */
    @After("@annotation(useDataSource)")
    public void doAfter(JoinPoint joinPoint, UseDataSource useDataSource) {
        log.info(String.format("当前数据源  %s  执行清理方法", useDataSource.dataSourceKey()));
        DataSourceContextHolder.clear();
    }
    
    
}
