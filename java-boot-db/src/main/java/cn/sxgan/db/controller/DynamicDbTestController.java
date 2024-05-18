package cn.sxgan.db.controller;

import cn.sxgan.common.entity.ClassesPO;
import cn.sxgan.common.mappers.BdExpClassesMapper;
import cn.sxgan.db.config.DataSourceContextHolder;
import cn.sxgan.db.enums.DataSourceEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 测试数据库动态切换
 * @Author: sxgan
 * @Date: 2024-05-18 20:12
 * @Version: 1.0
 **/
@Slf4j
@RestController
public class DynamicDbTestController {
    @Autowired
    BdExpClassesMapper bdExpClassesMapper;
    
    // 测试web
    @RequestMapping("/test")
    public String testWeb() {
        List<ClassesPO> classesPOS1 = bdExpClassesMapper.queryAa();
        log.info("no changed classesPOS1: {}", classesPOS1.toString());
        DataSourceContextHolder.set(DataSourceEnum.MOCK_DB_BACKUP);
        List<ClassesPO> classesPOS2 = bdExpClassesMapper.queryAa();
        log.info("changed classesPOS2: {}", classesPOS2.toString());
        DataSourceContextHolder.set(DataSourceEnum.MOCK_DB);
        List<ClassesPO> classesPOS3 = bdExpClassesMapper.queryAa();
        log.info("changed classesPOS3: {}", classesPOS3.toString());
        return "test web";
    }
}
