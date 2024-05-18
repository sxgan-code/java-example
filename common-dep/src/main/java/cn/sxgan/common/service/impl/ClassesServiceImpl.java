package cn.sxgan.common.service.impl;

import cn.sxgan.common.anno.UseDataSource;
import cn.sxgan.common.entity.ClassesPO;
import cn.sxgan.common.mappers.BdExpClassesMapper;
import cn.sxgan.common.service.ClassesService;
import cn.sxgan.common.enums.DataSourceEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.List;

@Slf4j
@Service
public class ClassesServiceImpl implements ClassesService {
    @Resource
    private BdExpClassesMapper bdExpClassesMapper;
    
    @Override
    public List<ClassesPO> selectClassesList() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("查询课程信息从随机库");
        List<ClassesPO> list = bdExpClassesMapper.queryAa();
        stopWatch.stop();
        log.info("stopWatch.getLastTaskTimeMillis() = {}", stopWatch.getLastTaskTimeMillis());
        log.info("stopWatch.prettyPrint() = {}", stopWatch.prettyPrint());
        return list;
    }
    
    @Override
    @UseDataSource(dataSourceKey = DataSourceEnum.MOCK_DB)
    public List<ClassesPO> findAllByMockDB() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("查询课程信息从MOCK_DB");
        List<ClassesPO> list = bdExpClassesMapper.queryAa();
        stopWatch.stop();
        log.info("stopWatch.getLastTaskTimeMillis() = {}", stopWatch.getLastTaskTimeMillis());
        log.info("stopWatch.prettyPrint() = {}", stopWatch.prettyPrint());
        return list;
    }
    
    @Override
    @UseDataSource(dataSourceKey = DataSourceEnum.MOCK_DB_BACKUP)
    public List<ClassesPO> findAllByMockBackupDB() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("查询课程信息从MOCK_DB_BACKUP");
        List<ClassesPO> list = bdExpClassesMapper.queryAa();
        stopWatch.stop();
        log.info("stopWatch.getLastTaskTimeMillis() = {}", stopWatch.getLastTaskTimeMillis());
        log.info("stopWatch.prettyPrint() = {}", stopWatch.prettyPrint());
        return list;
    }
}
