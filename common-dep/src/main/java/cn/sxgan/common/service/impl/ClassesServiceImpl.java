package cn.sxgan.common.service.impl;

import cn.sxgan.common.entity.ClassesPO;
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
    public List<ClassesPO> selectClassesList() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("查询课程信息");
        List<ClassesPO> list = bdExpClassesMapper.queryAa();
        stopWatch.stop();
        log.info("stopWatch.getLastTaskTimeMillis() = {}", stopWatch.getLastTaskTimeMillis());
        log.info("stopWatch.prettyPrint() = {}", stopWatch.prettyPrint());
        log.info(list.toString());
        return list;
    }
}
