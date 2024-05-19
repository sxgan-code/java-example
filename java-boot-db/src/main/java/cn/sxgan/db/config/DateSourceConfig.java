package cn.sxgan.db.config;

import cn.sxgan.common.enums.DataSourceEnum;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 设置数据源
 * @Author: sxgan
 * @Date: 2024/5/18 19:44
 * @Version: 1.0
 **/
@MapperScan(basePackages = "cn.sxgan.common.mappers")
@Configuration
public class DateSourceConfig {
    
    @Bean
    @ConfigurationProperties("spring.datasource.druid.mock-db")
    public DataSource masterDataSource() {
        return DruidDataSourceBuilder.create().build();
    }
    
    @Bean
    @ConfigurationProperties("spring.datasource.druid.mock-db-backup")
    public DataSource slaveDataSource() {
        return DruidDataSourceBuilder.create().build();
    }
    
    /**
     * 核心动态数据源
     *
     * @return 数据源实例
     */
    @Bean
    public DataSource dynamicDataSource() {
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setDefaultTargetDataSource(masterDataSource());
        Map<Object, Object> dataSourceMap = new HashMap<>(4);
        dataSourceMap.put(DataSourceEnum.MOCK_DB, masterDataSource());
        dataSourceMap.put(DataSourceEnum.MOCK_DB_BACKUP, slaveDataSource());
        dataSource.setTargetDataSources(dataSourceMap);
        return dataSource;
    }
    
    /**
     * 配置sqlSessionFactory
     *
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource());
        //此处设置为了解决找不到mapper文件的问题
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    
    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }
    
    /**
     * 事务管理
     *
     * @return 事务管理实例
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
    
}