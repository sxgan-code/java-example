package cn.sxgan.common.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 请求日志注解，该注解会打印请求入参和出参
 * @Author: sxgan
 * @Date: 2024/6/22 11:43
 * @Version: 1.0
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface RequestAroundLog {
}