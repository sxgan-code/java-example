package cn.sxgan.db.quartz;

import cn.sxgan.common.anno.WorkTime;
import cn.sxgan.common.entity.ClassesPO;
import cn.sxgan.common.enums.DataSourceEnum;
import cn.sxgan.common.mappers.BdExpClassesMapper;
import cn.sxgan.common.utils.CommonUtils;
import cn.sxgan.db.config.DataSourceContextHolder;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 同步数据库表数据, 注意：添加@EnableScheduling注解
 * @Author: sxgan
 * @Date: 2024-05-19 09:47
 * @Version: 1.0
 **/
@Slf4j
@Service
public class DataTableSyncJob {
    @Autowired
    BdExpClassesMapper bdExpClassesMapper;
    
    /**
     * 每10秒执行一次
     */
    @WorkTime(value = "同步数据库表Classes数据")
    @Scheduled(cron = "0/10 * * * * *")
    public void process() {
        List<ClassesPO> classesPOS1 = bdExpClassesMapper.queryAa();
        DataSourceContextHolder.set(DataSourceEnum.MOCK_DB_BACKUP);
        List<ClassesPO> classesPOS2 = bdExpClassesMapper.queryAa();
        // 判断对象存在变化则更新
        List<ClassesPO> updateList = Lists.newArrayList();
        classesPOS1.forEach(item1 -> {
            classesPOS2.forEach(item2 -> {
                if (item1.getId().equals(item2.getId())
                        && !CommonUtils.compareObjects(item1, item2, new String[]{"id", "name", "teacher"})) {
                    updateList.add(item1);
                }
            });
        });
        
        // 取差集，只有classesPOS1中有的元素，换句话说从classesPOS1中移除classesPOS2的元素
        List<ClassesPO> insertList = new java.util.ArrayList<>(classesPOS1.stream()
                .filter(item -> !classesPOS2.stream().map(ClassesPO::getId).toList().contains(item.getId()))
                .toList());
        insertList.addAll(updateList);
        
        log.info("同步数据库表Classes数据, 数据量: {}", insertList.size());
        log.info("当前数据库为：{}", DataSourceContextHolder.get());
        // 批量插入存在主键则更新
        if (!insertList.isEmpty()) {
            bdExpClassesMapper.batchInsertCourse(insertList);
        }
        DataSourceContextHolder.clear();
    }
}
