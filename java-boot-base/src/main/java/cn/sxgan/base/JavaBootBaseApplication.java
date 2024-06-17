package cn.sxgan.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "cn.sxgan.common.mappers", markerInterface = BaseMapper.class, annotationClass = Mapper.class)
@ComponentScan(basePackages = {"cn.sxgan.common.service.impl", "cn.sxgan.common.aspect", "cn.sxgan.base"})
public class JavaBootBaseApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(JavaBootBaseApplication.class, args);
    }
    
}
