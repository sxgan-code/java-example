package cn.sxgan.db.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
* @Description: 实现动态数据源，根据AbstractRoutingDataSource路由到不同数据源中
* @Author: sxgan
* @Date: 2024/5/18 19:42
* @Version: 1.0
**/
public class DynamicDataSource extends AbstractRoutingDataSource {
 
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.get();
    }
}