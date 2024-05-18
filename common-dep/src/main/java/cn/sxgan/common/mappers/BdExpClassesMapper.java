package cn.sxgan.common.mappers;


import cn.sxgan.common.entity.ClassesPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BdExpClassesMapper extends IBaseMapper<ClassesPO>{
    List<ClassesPO> queryAa();
}
