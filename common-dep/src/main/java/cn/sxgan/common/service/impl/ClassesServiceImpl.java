package cn.sxgan.common.service.impl;

import cn.sxgan.common.anno.UseDataSource;
import cn.sxgan.common.anno.WorkTime;
import cn.sxgan.common.entity.ClassesPO;
import cn.sxgan.common.enums.DataSourceEnum;
import cn.sxgan.common.mappers.BdExpClassesMapper;
import cn.sxgan.common.service.ClassesService;
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
    @WorkTime(value = "查询课程信息从随机库")
    public List<ClassesPO> selectClassesList() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("");
        return bdExpClassesMapper.queryAa();
    }
    
    @Override
    @WorkTime(value = "查询课程信息从MOCK_DB")
    @UseDataSource(dataSourceKey = DataSourceEnum.MOCK_DB)
    public List<ClassesPO> findAllByMockDB() {
        return bdExpClassesMapper.queryAa();
    }
    
    @Override
    @WorkTime(value = "查询课程信息从MOCK_DB_BACKUP")
    @UseDataSource(dataSourceKey = DataSourceEnum.MOCK_DB_BACKUP)
    public List<ClassesPO> findAllByMockBackupDB() {
        return bdExpClassesMapper.queryAa();
    }
}
