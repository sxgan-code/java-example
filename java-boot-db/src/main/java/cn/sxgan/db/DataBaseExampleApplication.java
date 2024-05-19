package cn.sxgan.db;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = "cn.sxgan.common.mappers", markerInterface = BaseMapper.class, annotationClass = Mapper.class)
@ComponentScan(basePackages = {"cn.sxgan.common.service.impl", "cn.sxgan.db"})
public class DataBaseExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataBaseExampleApplication.class, args);
    }
}