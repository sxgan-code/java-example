package cn.sxgan.db.config;

import cn.sxgan.common.enums.DataSourceEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 存储数据源上下文
 * @Author: sxgan
 * @Date: 2024/5/18 19:41
 * @Version: 1.0
 **/
@Slf4j
public class DataSourceContextHolder {
    
    private static final ThreadLocal<DataSourceEnum> currentDatesource = new ThreadLocal<>();
    
    /**
     * 清除当前数据源
     */
    public static void clear() {
        currentDatesource.remove();
    }
    
    /**
     * 获取当前使用的数据源
     *
     * @return 当前使用数据源的ID
     */
    public static DataSourceEnum get() {
        return currentDatesource.get();
    }
    
    /**
     * 设置当前使用的数据源
     *
     * @param value 需要设置的数据源ID
     */
    public static void set(DataSourceEnum value) {
        log.info("切换到数据源-->{}", value);
        currentDatesource.set(value);
    }
    
    /**
     * 设置从从库读取数据
     * 采用简单生成随机数的方式切换不同的从库
     */
    public static void setSlave() {
        if (Math.random() > 0.5) {
            DataSourceContextHolder.set(DataSourceEnum.MOCK_DB);
        } else {
            DataSourceContextHolder.set(DataSourceEnum.MOCK_DB_BACKUP);
        }
    }
    
}