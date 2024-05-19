package cn.sxgan.db.controller;

import cn.sxgan.common.entity.ClassesPO;
import cn.sxgan.common.enums.DataSourceEnum;
import cn.sxgan.common.mappers.BdExpClassesMapper;
import cn.sxgan.common.service.ClassesService;
import cn.sxgan.db.config.DataSourceContextHolder;
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
    
    @Autowired
    ClassesService classesServiceImpl;
    
    /**
     * 手动测试
     *
     * @return
     */
    @RequestMapping("/test")
    public String testWeb() {
        log.info("当前数据库为: {}", DataSourceContextHolder.get());
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
    
    /**
     * 测试切面
     */
    @RequestMapping("/test/aspect")
    public String testAspectChangeData() {
        List<ClassesPO> classesPOS1 = classesServiceImpl.selectClassesList();
        log.info("random change DB classesPOS: {}", classesPOS1.toString());
        List<ClassesPO> classesPOS2 = classesServiceImpl.findAllByMockDB();
        log.info("findAllByMockDB classesPOS: {}", classesPOS2.toString());
        List<ClassesPO> classesPOS3 = classesServiceImpl.findAllByMockBackupDB();
        log.info("findAllByMockBackupDB classesPOS: {}", classesPOS3.toString());
        return "test aspect";
    }
}
