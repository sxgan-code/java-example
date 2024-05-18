package cn.sxgan.common.service;


import cn.sxgan.common.entity.ClassesPO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author GSX
 * @since 2023-06-18 07:00:34
 */

public interface ClassesService{
    
    List<ClassesPO> selectClassesList();
    
    List<ClassesPO> findAllByMockDB();
    List<ClassesPO> findAllByMockBackupDB();
}
