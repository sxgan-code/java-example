package cn.sxgan.common.anno;

import cn.sxgan.common.enums.DataSourceEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 目标数据源注解
 * @Author: sxgan
 * @Date: 2024/5/18 22:47
 * @Version: 1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseDataSource {
    DataSourceEnum dataSourceKey() default DataSourceEnum.MOCK_DB;
}